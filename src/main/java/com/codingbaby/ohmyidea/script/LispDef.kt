package com.codingbaby.ohmyidea.script


/**
 * For webstorm
 */

object LispDef {

    var content = """
(do

(single

    [:0 :CompileDirty :编译]
    [:1 :FindInPath :文件中查找]
    [:2 :ReplaceInPath :文件中替换]
    [:3 :GoToRequestMapping :URL查找]
    [:4 :${'$'}Cut :剪切]
    [:5 :EditorDuplicate :复制行]
    [:6 :IntroduceVariable :提取变量]
    [:7 :EditorDeleteLine :删除行]
    [:8 :GotoFile :导航到文件]
    [:9 :GotoClass :导航到类]


    [:= :OH_ShowHelpDialog :显示帮助]
    [:- :ShowPopupMenu :模拟鼠标右键]

    [:` :OH_SwitchWindowAction :切换项目窗口]


    [:O :OH_ShowEnglishWordActions :补全单词]
    [:P :${'$'}EditorTranslateAction :翻译单词]



    [:h :EditorLeft :左移动]
    [:H :EditorLineStart :左开始]



    [:l :EditorRight :右移动]
    [:L :EditorLineEnd :右结束]

    [:j :EditorDown :下移动]
    [:J :OH_MotionLastLine :最后一行]


    [:k :EditorUp :上移动]
    [:K :OH_MotionFirstLine :第一行]

    [:t :NextTab :下一个选项卡]
    [:T :PreviousTab :前一个选项卡]

    [:s :NextSplitter :下一个拆分窗口]
    [:S :PrevSplitter :前一个拆分窗口]

    [:m :MethodDown :下一个方法声明]
    [:M :MethodUp :前一个方法声明]

    [:w :EditorNextWord :下一个单词]
    [:W :EditorPreviousWord :前一个单词]

    [:B :Forward :回退]
    [:b :Back :向前]

    [:u :${'$'}Undo :撤销]
    [:U :EditorToggleCase :转为大写]

    [:r :${'$'}Redo :重做]
    [:R :CloseContent :关闭选项卡]

    [:x :${'$'}Delete :删除字符]

    [:o :EditorStartNewLine :向后开始一个新行]

    [:p :${'$'}Paste :粘贴]

    [:e :EditorSelectWord :选择一个单词]
    [:E :EditorUnSelectWord :取消选择单词]

    [:q :FindUsages :查找使用]
    [:Q :ShowPopupMenu :模拟鼠标右键]

    [:/ :Find :查找]
    [:? :Replace :替换]

    [:f :SmartTypeCompletion :智能提示]
    [:F :FindWordAtCaret :查找当前单词]

    [:n :FindNext :下一个]
    [:N :FindPrevious :前一个]

    [:. :EditorCompleteStatement :语句完成]
    [:> :${'$'}Copy :复制行]

    [:< :GotoPreviousError :前一个错误]
    [:, :GotoNextError :后一个错误]

    [:c :ActivateVersionControlToolWindow :打开版本改动]

    [:: :OH_ShowCommandAction :命令底行开启]

    [:; :RunClass :运行当前类])


(composite

     [:gh :HideAllWindows :隐藏窗口]


     [:gd :GotoDeclaration :到声明]
     [:gm :GotoImplementation :到实现]
     [:gu :GotoSuperMethod :到超类]


     [:ge :Generate :生成代码]
     [:gv :IntroduceVariable :提取变量]
     [:gs :SurroundWith :代码环绕]

     [:de :EditorDeleteToLineEnd :删除到行尾]

     [:gw :JumpToLastWindow :最近窗口]

     [:gn :Inline :合并变量]


     [:gi :ShowIntentionActions :显示意图]


     [:yi :ImplementMethods :实现方法]
     [:yo :OverrideMethods :重载方法]


     [:zt :OH_ScrollToTop :当前行置顶]

     [:zj :EditorJoinLines :合并行]
     [:zs :OH_LoadScriptAction :加载模板]

     [:zf :ExpandRegion :打开折叠]
     [:zv :CollapseRegion :折叠代码]

     [:gr :RenameElement :重命名]

     [:yr :ReplaceInPath :文件中替换]
     [:yf :FindInPath :文件中查找]

     [:ys :Switcher :选择组件]
     [:yv :OH_ShowUIToggleActions :控制UI])


(select

    [:h :EditorLeftWithSelection :左选择]
       [:l :EditorRightWithSelection :右选择]
       [:j :EditorDownWithSelection :上选择]
       [:k :EditorUpWithSelection :下选择]

       [:H :EditorLineStartWithSelection :选择到行首]
       [:L :EditorLineEndWithSelection :选择到行尾]
       [:J :EditorScrollUp :编辑器上滚动]
       [:K :EditorScrollDown :编辑器下滚动]

       [:p :${'$'}Paste :粘贴]

       [:U :EditorToggleCase :转大写]
       [:u :${'$'}Undo :撤销]

       [:/ :CommentByBlockComment :块注释]
       [:x :${'$'}Delete :删除字符]
       [:r :ReformatCode :格式化代码]
       [:o :OptimizeImports :优化导入]

       [:e :JumpToLastChange :跳转到最近改动]

       [:> :${'$'}Copy :复制行]
       [:? :Replace :替换]

       [:n :MoveTabRight :编辑器右移]
       [:d :MoveTabDown :编辑器下移]

       [:. :OH_RepeatCurrentAction :重复上一个动作]


       [:c :EditorToggleColumnMode :列模式]
       [:s :SurroundWith :代码环绕])


(movement

    [:h :EditorLeft :左移动]
    [:H :EditorLineStart :左开始]

    [:0 :EditorLineStart :左开始]

    [:l :EditorRight :右移动]
    [:L :EditorLineEnd :右结束]
    [:9 :EditorLineEnd :右结束]

    [:j :EditorDown :下移动]
    [:J :OH_MotionLastLine :最后一行]

    [:G :OH_MotionLastLine :最后一行]

    [:k :EditorUp :上移动]
    [:K :OH_MotionFirstLine :第一行]

    [:e :MoveLineUp :上移动一行]
    [:E :MoveStatementUp :上移动块]

    [:d :MoveLineDown :下移动行]
    [:D :MoveStatementDown :下移动块]

    [:u :${'$'}Undo :撤销])


(bottom

    [:v :SplitVertically :水平拆分]
    [:h :SplitHorizontally :垂直拆分]

    [:s :ActivateStructureToolWindow :显示结构Tool]
    [:S :ActivateStructureToolWindow :显示结构Tool]

    [:p :ActivateProjectToolWindow :显示项目Tool]
    [:P :ActivateProjectToolWindow :显示项目Tool]

    [:t :ActivateTerminalToolWindow :显示终端Tool]
    [:T :ActivateTerminalToolWindow :显示终端Tool]

    [:r :ActivateRunToolWindow :显示运行Tool]
    [:R :ActivateRunToolWindow :显示运行Tool]

    [:b :ActivateDebugToolWindow :显示调试Tool]
    [:B :ActivateDebugToolWindow :显示调试Tool]

    [:d :ActivateTODOToolWindow :显示终端TODO]
    [:D :ActivateTODOToolWindow :显示终端TODO]

    [:< :EditorCodeBlockStart :到代码块开始]
    [:> :EditorCodeBlockEnd :到代码块结束]

    [:n :EditorToggleShowLineNumbers :定位到行])


)


    """

}