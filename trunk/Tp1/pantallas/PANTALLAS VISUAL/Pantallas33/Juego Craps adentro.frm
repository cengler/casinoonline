VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H0080FF80&
   Caption         =   "Ingresando Craps"
   ClientHeight    =   5295
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4365
   LinkTopic       =   "Form1"
   ScaleHeight     =   5295
   ScaleWidth      =   4365
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command2 
      Caption         =   "Abrir una nueva mesa"
      Height          =   375
      Left            =   240
      TabIndex        =   9
      Top             =   4800
      Width           =   3975
   End
   Begin VB.ListBox List1 
      Height          =   1425
      Left            =   240
      TabIndex        =   8
      Top             =   2760
      Width           =   3975
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Unirse a mesa"
      Height          =   375
      Left            =   240
      TabIndex        =   4
      Top             =   4320
      Width           =   3975
   End
   Begin VB.Frame Frame1 
      BackColor       =   &H0080FF80&
      Caption         =   "Jugador"
      Height          =   495
      Left            =   120
      TabIndex        =   0
      Top             =   0
      Width           =   3135
   End
   Begin VB.Label Label7 
      BackStyle       =   0  'Transparent
      BorderStyle     =   1  'Fixed Single
      Caption         =   "VALOR POZO GORDO PROGRESIVO"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   -1  'True
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   2280
      TabIndex        =   7
      Top             =   1920
      Width           =   1935
   End
   Begin VB.Label Label6 
      BackStyle       =   0  'Transparent
      BorderStyle     =   1  'Fixed Single
      Caption         =   "VALOR POZO FELIZ"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   -1  'True
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   1440
      TabIndex        =   6
      Top             =   1560
      Width           =   2775
   End
   Begin VB.Label Label5 
      BackStyle       =   0  'Transparent
      BorderStyle     =   1  'Fixed Single
      Caption         =   "SALDO ACTUAL"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   -1  'True
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   840
      TabIndex        =   5
      Top             =   720
      Width           =   2655
   End
   Begin VB.Line Line1 
      BorderWidth     =   2
      X1              =   0
      X2              =   6120
      Y1              =   1200
      Y2              =   1200
   End
   Begin VB.Label Label3 
      BackStyle       =   0  'Transparent
      Caption         =   "Saldo"
      Height          =   255
      Left            =   120
      TabIndex        =   3
      Top             =   720
      Width           =   495
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Premio Gordo Progresivo:"
      Height          =   255
      Index           =   1
      Left            =   360
      TabIndex        =   2
      Top             =   2040
      Width           =   1935
   End
   Begin VB.Label Label1 
      BackStyle       =   0  'Transparent
      Caption         =   "Pozo Feliz:"
      Height          =   255
      Index           =   1
      Left            =   360
      TabIndex        =   1
      Top             =   1560
      Width           =   975
   End
   Begin VB.Line Line2 
      BorderWidth     =   2
      X1              =   0
      X2              =   4200
      Y1              =   2520
      Y2              =   2520
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
Form2.Show
End Sub

