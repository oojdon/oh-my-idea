SetCapsLockState, AlwaysOff
#Hotstring EndChars `;

;===========================;I = Home
CapsLock & i::
if getkeystate("alt") = 0
Send, {Home}
else
Send, +{Home}
return

;===========================;O = End
CapsLock & o::
if getkeystate("alt") = 0
Send, {End}
else
Send, +{End}
return


;===========================;H = Left
CapsLock & h::
if getkeystate("alt") = 0
Send, {Left}
else
Send, +{Left}
return

;===========================;J = Down
CapsLock & j::
if getkeystate("alt") = 0
Send, {Down}
else
Send, +{Down}
return

;===========================;K = UP
CapsLock & k::
if getkeystate("alt") = 0
Send, {Up}
else
Send, +{Up}
return

;===========================;L = Right
CapsLock & l::
if getkeystate("alt") = 0
Send, {Right}
else
Send, +{Right}
return


;;============================Editor================================||
CapsLock & f:: Send, ^x
CapsLock & y:: Send, ^c
CapsLock & p:: Send, ^v


;;=============================Deletor==============================||
CapsLock & ,:: Send, {Del}              ; , = Del char after
CapsLock & .:: Send, ^{Del}             ; . = Del word after
CapsLock & /:: Send, +{End}{Del}        ; / = Del all  after

CapsLock & m:: Send, {BS}               ; m = Del char before;
CapsLock & n:: Send, ^{BS}              ; n = Del word before;
CapsLock & b:: Send, +{Home}{Del}       ; b = Del all  before;


;;============================Special Char==========================||
CapsLock & ':: Send, =
CapsLock & `;:: Send, |
CapsLock & 8:: Send, {!}
CapsLock & 1::send,``
CapsLock & 2::send,{~}


;;===========================Controller=============================||
CapsLock:: Send, ^i
CapsLock & u::Send, {ESC}


;;=========================Application==============================||
CapsLock & e:: Run https://www.infoq.cn
CapsLock & g:: Run https://www.google.com.hk


CapsLock & +::send,{Volume_Up}
CapsLock & -::send,{Volume_Down}

::vp::vsce package
::repo::repo sync -c -j4
