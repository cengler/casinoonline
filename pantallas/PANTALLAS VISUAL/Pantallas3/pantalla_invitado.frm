VERSION 5.00
Begin VB.Form Form3 
   BackColor       =   &H0080FF80&
   Caption         =   "Invitado"
   ClientHeight    =   6255
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6765
   LinkTopic       =   "Form3"
   ScaleHeight     =   6255
   ScaleWidth      =   6765
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command2 
      Caption         =   "Entrar"
      Height          =   375
      Left            =   240
      TabIndex        =   4
      Top             =   5040
      Width           =   3135
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Salir del casino"
      Height          =   615
      Left            =   240
      TabIndex        =   3
      Top             =   5520
      Width           =   3135
   End
   Begin VB.ListBox List1 
      Height          =   3180
      ItemData        =   "pantalla_invitado.frx":0000
      Left            =   240
      List            =   "pantalla_invitado.frx":0010
      TabIndex        =   2
      Top             =   1680
      Width           =   3135
   End
   Begin VB.Frame Frame1 
      BackColor       =   &H0080FF80&
      Caption         =   "Invitado"
      Height          =   495
      Left            =   240
      TabIndex        =   1
      Top             =   360
      Width           =   3135
   End
   Begin VB.Label Label1 
      BackStyle       =   0  'Transparent
      Caption         =   "Mesas abiertas disponibles para observar:"
      Height          =   375
      Left            =   240
      TabIndex        =   0
      Top             =   1200
      Width           =   3255
   End
End
Attribute VB_Name = "Form3"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
