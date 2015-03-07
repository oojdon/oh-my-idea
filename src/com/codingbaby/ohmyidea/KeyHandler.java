package com.codingbaby.ohmyidea;

import com.codingbaby.ohmyidea.helper.RunnableHelper;
import com.codingbaby.ohmyidea.key.*;
import com.codingbaby.ohmyidea.script.CodeQuick;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 */
public class KeyHandler {

    private static KeyHandler instance;

    public static int toLine;

    public static char toChar;

    @NotNull
    public static KeyHandler getInstance() {
        if (instance == null) {
            instance = new KeyHandler();
        }
        return instance;
    }

    public void handleKey(@NotNull final Editor editor, @NotNull KeyStroke key, @NotNull final DataContext context) {

        final OhPlugin oh = OhPlugin.getInstance();

        if (oh.commandStatus.isWaiting()) {

            if (KeyStroke.getKeyStroke('i') == key) {
                toInsertMod();
                return;
            }

            if (KeyStroke.getKeyStroke('I') == key) {
                toDebugMod();
                return;
            }

            if (KeyStroke.getKeyStroke('v') == key) {
                toVisualMod();
                return;
            }

            if (KeyStroke.getKeyStroke('V') == key) {
                toMoveMod();
                return;
            }

        }

        oh.commandStatus.addChar(key.getKeyChar());

        CommandNode commandNode = null;
        if (oh.commandStatus.hasStroke()) {
            if (oh.status == EditorStatus.Command) {
                commandNode = SingleShort.get(oh.commandStatus.getStroke());
            }
            if (oh.status == EditorStatus.Visual) {
                commandNode = VisualShort.get(oh.commandStatus.getStroke());
            }
            if (oh.status == EditorStatus.Move) {
                commandNode = MoveShort.get(oh.commandStatus.getStroke());
            }
            if (oh.status == EditorStatus.Debug) {
                commandNode = DebugShort.get(oh.commandStatus.getStroke());
            }
        } else {
            commandNode = ComposeShort.get(oh.commandStatus.getCommand());
        }

        //快捷模式
        if (commandNode != null) {
            Project project = editor.getProject();
            if (ApplicationManager.getApplication().isDispatchThread()) {
                Runnable action = new ActionRunner(context, commandNode);
                String name = commandNode.getAction().getTemplatePresentation().getText();
                RunnableHelper.runReadCommand(project, action, name, action);
            }
            oh.commandStatus.reset();
            return;
        }


        //行字符搜索
        if (oh.commandStatus.getForwardChar() != null) {
            Project project = editor.getProject();
            toChar = oh.commandStatus.getForwardChar();
            Runnable cmd = new Runnable() {
                @Override
                public void run() {
                    executeAction("MotionToMatchChar", context);
                }
            };
            RunnableHelper.runReadCommand(project, cmd, "moveCharInLine", cmd);
            oh.commandStatus.reset();
            return;
        }

        //代码模板
        if (oh.commandStatus.getCodeKey() != null) {
            Project project = editor.getProject();
            final String mapping = CodeQuick.getMapping(oh.commandStatus.getCodeKey());
            if (mapping != null) {
                Runnable cmd = new Runnable() {
                    @Override
                    public void run() {
                        int oldOffset = editor.getCaretModel().getOffset();
                        editor.getDocument().insertString(oldOffset, mapping);
                        oh.commandStatus.reset();

                        executeAction("ReformatCode", context);
                    }
                };
                RunnableHelper.runWriteCommand(project, cmd, "insertCode", cmd);
            }
            return;
        }

    }

    public static void toInsertMod() {
        final OhPlugin oh = OhPlugin.getInstance();
        oh.status = EditorStatus.Insert;
        oh.setCursors(false);
        oh.commandStatus.reset();
    }

    public static void toVisualMod() {
        final OhPlugin oh = OhPlugin.getInstance();
        oh.status = EditorStatus.Visual;
        oh.commandStatus.reset();
    }

    public static void toMoveMod() {
        final OhPlugin oh = OhPlugin.getInstance();
        oh.status = EditorStatus.Move;
        oh.commandStatus.reset();
    }


    public static void toDebugMod() {
        final OhPlugin oh = OhPlugin.getInstance();
        oh.status = EditorStatus.Debug;
        oh.commandStatus.reset();
    }

    public static void toCommandMod() {
        final OhPlugin oh = OhPlugin.getInstance();
        oh.getInstance().setCursors(true);
        oh.getInstance().status = EditorStatus.Command;
        oh.commandStatus.reset();
    }

    public static void executeAction(@NotNull String name, @NotNull DataContext context) {
        ActionManager aMgr = ActionManager.getInstance();
        AnAction action = aMgr.getAction(name);
        if (action != null) {
            executeAction(action, context);
        }
    }

    public static void executeAction(@NotNull AnAction action, @NotNull DataContext context) {
        action.actionPerformed(new AnActionEvent(null, context, "", action.getTemplatePresentation(), ActionManager.getInstance(), 0));
    }

    static class ActionRunner implements Runnable {
        public ActionRunner(DataContext context, CommandNode cmd) {
            this.context = context;
            this.cmd = cmd;
        }

        public void run() {
            executeAction(cmd.getAction(), context);
        }

        private final DataContext context;
        private final CommandNode cmd;
    }


}
