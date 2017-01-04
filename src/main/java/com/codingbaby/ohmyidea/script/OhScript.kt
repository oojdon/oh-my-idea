package com.codingbaby.ohmyidea.script

import com.codingbaby.ohmyidea.key.*
import com.codingbaby.ohmyidea.shortcut.*
import com.intellij.openapi.util.io.FileUtil
import groovy.lang.Binding
import groovy.lang.GroovyClassLoader
import org.apache.commons.lang.StringUtils
import org.codehaus.groovy.runtime.InvokerHelper
import java.io.File
import java.io.IOException
import java.util.*


object OhScript {

    val OH_FILE = ".oh-my-idea"

    val dsl = """

import java.awt.Robot;
import java.awt.event.KeyEvent;

class RobotContainer {

        def outerList

        RobotContainer(env){
            outerList = env
        }

        def key(key,list) {
            outerList[key] = list
        }
}


class CodeContainer {

        def outerList

        def holder

        CodeContainer(env){
            outerList = env
        }


    def key(key) {
        holder = [:]
        holder["key"] = key
    }

    def desc(desc) {
        holder["desc"] = desc

    }

    def code(code) {
        holder["code"] = code
        outerList << holder
    }

}

class ActorContainer {

        def outerAction


        ActorContainer(env){
            outerAction = env
        }


    def actor(key,action,desc) {
            outerAction.add(key, action, desc)
    }


}

def oh = {
    closure ->
        closure.delegate = new CodeContainer(envList)
        closure()
}

def ho = {
    closure ->
        closure.delegate = new RobotContainer(envMap)
        closure()
}

def vv = {
    closure ->
        closure.delegate = new ActorContainer(vmode)
        closure()
}

def ss = {
    closure ->
        closure.delegate = new ActorContainer(smode)
        closure()
}

def mm = {
    closure ->
        closure.delegate = new ActorContainer(mmode)
        closure()
}

def cc = {
    closure ->
        closure.delegate = new ActorContainer(cmode)
        closure()
}

def bb = {
    closure ->
        closure.delegate = new ActorContainer(bmode)
        closure()
}

ss {

    actor("h", "EditorLeft", "左移动")
    actor("H", "EditorLineStart", "左开始")

    actor("0", "EditorLineStart", "左开始")

    actor("l", "EditorRight", "右移动")
    actor("L", "EditorLineEnd", "右结束")
    actor("9", "EditorLineEnd", "右结束")

    actor("j", "EditorDown", "下移动")
    actor("J", "OH_MotionLastLine", "最后一行")

    actor("G", "OH_MotionLastLine", "最后一行")

    actor("k", "EditorUp", "上移动")
    actor("K", "OH_MotionFirstLine", "第一行")

    actor("t", "NextTab", "下一个选项卡")
    actor("T", "PreviousTab", "前一个选项卡")

    actor("s", "NextSplitter", "下一个拆分窗口")
    actor("S", "PrevSplitter", "钱一个拆分窗口")

    actor("m", "MethodDown", "下一个方法声明")
    actor("M", "MethodUp", "前一个方法声明")

    actor("w", "EditorNextWord", "下一个单词")
    actor("W", "EditorPreviousWord", "前一个单词")

    actor("B", "Forward", "回退")
    actor("b", "Back", "向前")

    actor("u", "\${'$'}Undo", "撤销")
    actor("U", "EditorToggleCase", "转为大写")

    actor("r", "\${'$'}Redo", "重做")
    actor("R", "CloseContent", "关闭选项卡")

    actor("x", "\${'$'}Delete", "删除字符")

    actor("O", "EditorStartNewLineBefore", "向前开始一个新行")
    actor("o", "EditorStartNewLine", "向后开始一个新行")

    actor("p", "\${'$'}Paste", "粘贴")

    actor("e", "EditorSelectWord", "选择一个单词")
    actor("E", "EditorUnSelectWord", "取消选择单词")

    actor("q", "FindUsages", "查找使用")
    actor("Q", "ShowPopupMenu", "模拟鼠标右键")

    actor("/", "Find", "查找")
    actor("?", "Replace", "替换")

    actor("f", "SmartTypeCompletion", "智能提示")
    actor("F", "FindWordAtCaret", "查找当前单词")

    actor("n", "FindNext", "下一个")
    actor("N", "FindPrevious", "前一个")

    actor(".", "EditorCompleteStatement", "语句完成")
    actor(">", "\${'$'}Copy", "复制行")

    actor("<", "GotoPreviousError", "前一个错误")
    actor(",", "GotoNextError", "后一个错误")

    actor("c", "ActivateVersionControlToolWindow", "打开版本改动")

    actor(":", "OH_ShowCommandAction", "命令底行开启")

    actor("I", "OH_NotQuickInsert", "快速非运算")

}

vv {

    actor("h", "EditorLeftWithSelection", "左选择")
    actor("l", "EditorRightWithSelection", "右选择")
    actor("j", "EditorDownWithSelection", "上选择")
    actor("k", "EditorUpWithSelection", "下选择")

    actor("H", "EditorLineStartWithSelection", "选择到行首")
    actor("L", "EditorLineEndWithSelection", "选择到行尾")
    actor("J", "EditorScrollUp", "编辑器上滚动")
    actor("K", "EditorScrollDown", "编辑器下滚动")

    actor("p", "\${'$'}Paste", "粘贴")

    actor("U", "EditorToggleCase", "转位大写")
    actor("u", "\${'$'}Undo", "撤销")

    actor("/", "CommentByBlockComment", "块注释")
    actor("x", "\${'$'}Delete", "删除字符")
    actor("r", "ReformatCode", "格式化代码")
    actor("o", "OptimizeImports", "优化导入")

    actor("e", "JumpToLastChange", "跳转到最近改动")

    actor(">", "\${'$'}Copy", "复制行")
    actor("?", "Replace", "替换")

    actor("n", "MoveTabRight", "编辑器右移")
    actor("d", "MoveTabDown", "编辑器下移")

    actor(".", "OH_RepeatCurrentAction", "重复上一个动作")

    actor("c", "RunClass", "运行当前类")
    actor("b", "DebugClass", "调试当前类")
    actor("t", "ToggleTemporaryLineBreakpoint", "临时断点")
    actor("g", "StepOver", "行跳过")
    actor("i", "StepOver", "行进入")

}

mm {

    actor("h", "EditorLeft", "左移动")
    actor("H", "EditorLineStart", "左开始")

    actor("0", "EditorLineStart", "左开始")

    actor("l", "EditorRight", "右移动")
    actor("L", "EditorLineEnd", "右结束")
    actor("9", "EditorLineEnd", "右结束")

    actor("j", "EditorDown", "下移动")
    actor("J", "OH_MotionLastLine", "最后一行")

    actor("G", "OH_MotionLastLine", "最后一行")

    actor("k", "EditorUp", "上移动")
    actor("K", "OH_MotionFirstLine", "第一行")

    actor("e", "MoveLineUp", "上移动一行")
    actor("E", "MoveStatementUp", "上移动块")

    actor("d", "MoveLineDown", "下移动行")
    actor("D", "MoveStatementDown", "下移动块")

    actor("u", "\${'$'}Undo", "撤销")
}

cc {

    actor("gd", "GotoDeclaration", "到声明")
    actor("gm", "GotoImplementation", "到实现")
    actor("gu", "GotoSuperMethod", "到超类")

    actor("gg", "OH_MotionFirstLine", "到第一行")

    actor("ge", "Generate", "生成代码")
    actor("gv", "IntroduceVariable", "提取变量")
    actor("gs", "SurroundWith", "代码环绕")

    actor("dd", "EditorDeleteLine", "删除行")
    actor("de", "EditorDeleteToLineEnd", "删除到行尾")

    actor("dG", "OH_EditorDeleteToFileEnd", "删除到行尾")

    actor("gh", "HideAllWindows", "隐藏窗口")
    actor("gp", "NextProjectWindow", "下一个项目窗口")
    actor("gw", "JumpToLastWindow", "最近窗口")

    actor("go", "GotoClass", "导航到类")
    actor("gn", "Inline", "合并变量")
    actor("gf", "GotoFile", "导航到文件")

    actor("ye", "OH_EditCodeTemplate", "编辑代码模板")

    //意图
    actor("gi", "ShowIntentionActions", "显示意图")

    actor("yc", "\${'$'}Cut", "剪切")
    actor("yd", "EditorDuplicate", "复制行")

    actor("yi", "ImplementMethods", "实现方法")
    actor("yo", "OverrideMethods", "重载方法")

    actor("yb", "CompileDirty", "编译")

    actor("zt", "OH_ScrollToTop", "当前行置顶")

    actor("zj", "EditorJoinLines", "合并行")
    actor("zs", "OH_LoadScriptAction", "加载模板")

    actor("zf", "ExpandRegion", "打开折叠")
    actor("zv", "CollapseRegion", "折叠代码")

    actor("gr", "RenameElement", "重命名")

    //这两个命令比较特殊,需要让打开的窗口的命令模式失效
    actor("yr", "ReplaceInPath", "文件中替换")
    actor("yf", "FindInPath", "文件中查找")

    actor("ys", "Switcher", "选择组件")
    actor("yv", "OH_ShowUIToggleActions", "控制UI")

}

bb {

    actor("v", "SplitVertically", "水平拆分")
    actor("h", "SplitHorizontally", "垂直拆分")

    actor("s", "ActivateStructureToolWindow", "显示结构Tool")
    actor("S", "ActivateStructureToolWindow", "显示结构Tool")

    actor("p", "ActivateProjectToolWindow", "显示项目Tool")
    actor("P", "ActivateProjectToolWindow", "显示项目Tool")

    actor("t", "ActivateTerminalToolWindow", "显示终端Tool")
    actor("T", "ActivateTerminalToolWindow", "显示终端Tool")

    actor("r", "ActivateRunToolWindow", "显示运行Tool")
    actor("R", "ActivateRunToolWindow", "显示运行Tool")

    actor("b", "ActivateDebugToolWindow", "显示调试Tool")
    actor("B", "ActivateDebugToolWindow", "显示调试Tool")

    actor("d", "ActivateTODOToolWindow", "显示终端TODO")
    actor("D", "ActivateTODOToolWindow", "显示终端TODO")

    actor("<", "EditorCodeBlockStart", "到代码块开始")
    actor(">", "EditorCodeBlockEnd", "到代码块结束")

    actor("n", "EditorToggleShowLineNumbers", "显示行号")

    actor("k", "OH_ShowHelpDialog", "显示帮助")
    actor("K", "OH_ShowHelpDialog", "显示帮助")

}


"""


    fun loadScriptFile() {
        if (try {
            Class.forName("groovy.lang.GroovyClassLoader")
            false
        } catch (e: Exception) {
            true
        }) {
            return
        }

        val content = loadContent()
        loadGroovy(content)
    }


    fun loadGroovy(text: String) {
        val groovyClassLoader = GroovyClassLoader()
        val scriptClass = groovyClassLoader.parseClass(dsl + text)

        var keyHolder = ArrayList<HashMap<String, String>>()
        var robotHolder = HashMap<String, List<Int>>()

        var bind = Binding()
        bind.setVariable("envList", keyHolder)
        bind.setVariable("envMap", robotHolder)


        bind.setVariable("vmode", VisualShort.commandHolder)
        bind.setVariable("smode", SingleShort.commandHolder)
        bind.setVariable("mmode", MoveShort.commandHolder)
        bind.setVariable("cmode", ComposeShort.commandHolder)
        bind.setVariable("bmode", BottomShort.commandHolder)

        InvokerHelper.createScript(scriptClass, bind).run()

        RobotHandler.holder.clear()
        RobotHandler.holder.putAll(robotHolder)

        CodeSnippet.desc.clear()
        CodeSnippet.code.clear()

        for (map in keyHolder) {
            var key = map["key"]
            var desc = map["desc"]
            var code = map["code"]

            CodeSnippet.desc.put(key as String, desc as String)
            CodeSnippet.code.put(key, code as String)
        }
    }


    fun saveScript(text: String) {
        if (StringUtils.isNotBlank(text)) {
            val homeDirName = System.getProperty("user.home")
            if (homeDirName != null) {
                val file = File(homeDirName, OH_FILE)
                try {
                    FileUtil.writeToFile(file, text)
                    loadScriptFile()
                } catch (e: IOException) {
                }

            }
        }
    }

    fun loadContent(): String {
        val homeDirName = System.getProperty("user.home")
        if (homeDirName != null) {
            val file = File(homeDirName, OH_FILE)
            if (file.exists()) {
                try {
                    return file.readText(Charsets.UTF_8)
                } catch (e: IOException) {
                    return ""
                }
            }
        }
        return ""
    }


}
