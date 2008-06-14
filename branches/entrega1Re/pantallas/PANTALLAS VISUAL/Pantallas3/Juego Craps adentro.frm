VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H0080FF80&
   Caption         =   "Ingresando Craps"
   ClientHeight    =   5430
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6135
   LinkTopic       =   "Form1"
   ScaleHeight     =   5430
   ScaleWidth      =   6135
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command1 
      Caption         =   "Entrar"
      Height          =   495
      Left            =   360
      TabIndex        =   9
      Top             =   3720
      Width           =   1815
   End
   Begin VB.ComboBox Combo1 
      Height          =   315
      Left            =   360
      TabIndex        =   8
      Text            =   "Nueva"
      Top             =   3120
      Width           =   1815
   End
   Begin VB.TextBox Text3 
      Height          =   285
      Left            =   720
      TabIndex        =   3
      Top             =   720
      Width           =   2535
   End
   Begin VB.Frame Frame1 
      BackColor       =   &H0080FF80&
      Caption         =   "Jugador"
      Height          =   495
      Left            =   120
      TabIndex        =   2
      Top             =   0
      Width           =   3135
   End
   Begin VB.TextBox Text2 
      Height          =   285
      Index           =   1
      Left            =   2280
      TabIndex        =   1
      Top             =   2040
      Width           =   1935
   End
   Begin VB.TextBox Text1 
      Height          =   285
      Index           =   1
      Left            =   1440
      TabIndex        =   0
      Top             =   1440
      Width           =   2775
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Unirse a mesa:"
      Height          =   255
      Left            =   360
      TabIndex        =   7
      Top             =   2760
      Width           =   1215
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
      TabIndex        =   6
      Top             =   720
      Width           =   495
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Premio Gordo Progresivo:"
      Height          =   255
      Index           =   1
      Left            =   360
      TabIndex        =   5
      Top             =   2040
      Width           =   1935
   End
   Begin VB.Label Label1 
      BackStyle       =   0  'Transparent
      Caption         =   "Pozo Feliz:"
      Height          =   255
      Index           =   1
      Left            =   360
      TabIndex        =   4
      Top             =   1560
      Width           =   975
   End
   Begin VB.Line Line2 
      BorderWidth     =   2
      X1              =   0
      X2              =   6120
      Y1              =   2520
      Y2              =   2520
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
