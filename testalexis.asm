extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586

.CODE
debut :
STARTUPCODE
mov bp,sp
sub sp,6
.DATA
mess0 DB " x= $"
.CODE
lea dx,mess0
push dx
call ecrch
lea dx, [bp-2]
push dx
call lirent
call ligsuiv
.DATA
mess1 DB " y= $"
.CODE
lea dx,mess1
push dx
call ecrch
lea dx, [bp-4]
push dx
call lirent
call ligsuiv
.DATA
mess2 DB " x+y= $"
.CODE
lea dx,mess2
push dx
call ecrch
push word ptr [bp-2]
push word ptr [bp-4]
pop bx
pop ax
add ax,bx
push ax
call ecrent
call ligsuiv
push word ptr [bp-2]
push word ptr [bp-4]
push word ptr 2
pop bx
pop ax
cwd
idiv bx
push ax
pop bx
pop ax
add ax,bx
push ax
push word ptr -1
pop bx
pop ax
cwd
idiv bx
push ax
push word ptr [bp-4]
push word ptr 3
push word ptr [bp-4]
pop bx
pop ax
imul bx
push ax
pop bx
pop ax
add ax,bx
push ax
push word ptr 4
pop bx
pop ax
sub ax,bx
push ax
pop ax
mov word ptr [bp-2], ax
