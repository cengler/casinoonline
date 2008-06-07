VERSION 5.00
Begin VB.Form Form1 
   BackColor       =   &H0080FF80&
   Caption         =   "Dentro del Casino"
   ClientHeight    =   5355
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6120
   LinkTopic       =   "Eligiendo juego"
   ScaleHeight     =   5355
   ScaleWidth      =   6120
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command5 
      Caption         =   "Observar Mesas Craps"
      Height          =   495
      Left            =   3720
      TabIndex        =   11
      Top             =   3840
      Width           =   2175
   End
   Begin VB.CommandButton Command4 
      Caption         =   "Observar Mesas Tragamonedas"
      Height          =   495
      Left            =   3720
      TabIndex        =   10
      Top             =   3120
      Width           =   2175
   End
   Begin VB.CommandButton Command3 
      Caption         =   "Salir del Casino"
      Height          =   495
      Left            =   360
      TabIndex        =   6
      Top             =   4560
      Width           =   3255
   End
   Begin VB.Frame Frame1 
      BackColor       =   &H0080FF80&
      Caption         =   "Jugador"
      Height          =   495
      Left            =   120
      TabIndex        =   4
      Top             =   120
      Width           =   3135
   End
   Begin VB.CommandButton Command2 
      Caption         =   "Jugar Craps"
      Height          =   495
      Left            =   360
      TabIndex        =   3
      Top             =   3840
      Width           =   3255
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Jugar Tragamonedas"
      Height          =   495
      Left            =   360
      TabIndex        =   0
      Top             =   3120
      Width           =   3255
   End
   Begin VB.Label Label6 
      BackStyle       =   0  'Transparent
      BorderStyle     =   1  'Fixed Single
      Caption         =   "VALOR PREMIO GORDO PROGRESIVO"
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
      Left            =   2520
      TabIndex        =   9
      Top             =   2280
      Width           =   2415
   End
   Begin VB.Label Label5 
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
      Height          =   375
      Left            =   1560
      TabIndex        =   8
      Top             =   1800
      Width           =   3375
   End
   Begin VB.Label Label4 
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
      Height          =   375
      Left            =   840
      TabIndex        =   7
      Top             =   720
      Width           =   2775
   End
   Begin VB.Line Line1 
      BorderWidth     =   2
      X1              =   0
      X2              =   6120
      Y1              =   1320
      Y2              =   1320
   End
   Begin VB.Label Label3 
      BackStyle       =   0  'Transparent
      Caption         =   "Saldo"
      Height          =   255
      Left            =   120
      TabIndex        =   5
      Top             =   840
      Width           =   495
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Premio Gordo Progresivo:"
      Height          =   255
      Left            =   480
      TabIndex        =   2
      Top             =   2400
      Width           =   1935
   End
   Begin VB.Label Label1 
      BackStyle       =   0  'Transparent
      Caption         =   "Pozo Feliz:"
      Height          =   255
      Left            =   480
      TabIndex        =   1
      Top             =   1920
      Width           =   975
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

Private Sub Command2_Click()
Form3.Show
End Sub
