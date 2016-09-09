package com.codingbaby.ohmyidea.key;

import javax.swing.*;

/**
 * 底行快捷键
 */
public class BottomShort {

    public static CommandHolder commandHolder  = new CommandHolder();


    static {

        commandHolder.add("v","SplitVertically","水平拆分");
        commandHolder.add("h","SplitHorizontally","垂直拆分");

        commandHolder.add("s","ActivateStructureToolWindow","显示结构Tool");
        commandHolder.add("S","ActivateStructureToolWindow","显示结构Tool");

        commandHolder.add("p","ActivateProjectToolWindow","显示项目Tool");
        commandHolder.add("P","ActivateProjectToolWindow","显示项目Tool");

        commandHolder.add("t","ActivateTerminalToolWindow","显示终端Tool");
        commandHolder.add("T","ActivateTerminalToolWindow","显示终端Tool");

        commandHolder.add("d","ActivateTODOToolWindow","显示终端TODO");
        commandHolder.add("D","ActivateTODOToolWindow","显示终端TODO");

        commandHolder.add("<","EditorCodeBlockStart","到代码块开始");
        commandHolder.add(">","EditorCodeBlockEnd","到代码块结束");

        commandHolder.add("n","EditorToggleShowLineNumbers","显示行号");

        commandHolder.add("k","ShowHelpDialog","显示帮助");

    }

    public static CommandNode get(KeyStroke keyStroke) {
        return  commandHolder.get(keyStroke);
    }

}
