VERSION 5.00
Begin VB.Form Form2 
   BackColor       =   &H0080FF80&
   Caption         =   "Tragamonedas"
   ClientHeight    =   6345
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   6210
   LinkTopic       =   "Form2"
   ScaleHeight     =   6345
   ScaleWidth      =   6210
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text2 
      Height          =   285
      Index           =   5
      Left            =   1680
      TabIndex        =   22
      Top             =   5040
      Width           =   2055
   End
   Begin VB.TextBox Text2 
      Height          =   285
      Index           =   4
      Left            =   2400
      TabIndex        =   20
      Top             =   4560
      Width           =   615
   End
   Begin VB.TextBox Text2 
      Height          =   285
      Index           =   0
      Left            =   3120
      TabIndex        =   19
      Top             =   4560
      Width           =   615
   End
   Begin VB.TextBox Text2 
      Height          =   285
      Index           =   3
      Left            =   1680
      TabIndex        =   18
      Top             =   4560
      Width           =   615
   End
   Begin VB.TextBox Text2 
      Height          =   285
      Index           =   2
      Left            =   1680
      TabIndex        =   16
      Top             =   4080
      Width           =   2055
   End
   Begin VB.TextBox Text1 
      Height          =   285
      Index           =   1
      Left            =   1440
      TabIndex        =   12
      Top             =   1440
      Width           =   2775
   End
   Begin VB.TextBox Text2 
      Height          =   285
      Index           =   1
      Left            =   2280
      TabIndex        =   11
      Top             =   2040
      Width           =   1935
   End
   Begin VB.CommandButton Command2 
      Caption         =   "Salir del juego"
      Height          =   375
      Left            =   1080
      TabIndex        =   10
      Top             =   5760
      Width           =   2655
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Apostar"
      Height          =   375
      Left            =   2760
      TabIndex        =   9
      Top             =   3480
      Width           =   1935
   End
   Begin VB.ComboBox Combo2 
      Height          =   315
      Left            =   1680
      TabIndex        =   8
      Top             =   3480
      Width           =   615
   End
   Begin VB.TextBox Text1 
      Height          =   285
      Index           =   0
      Left            =   4680
      TabIndex        =   6
      Top             =   120
      Width           =   1215
   End
   Begin VB.ComboBox Combo1 
      Height          =   315
      Left            =   1680
      TabIndex        =   4
      Top             =   3000
      Width           =   2055
   End
   Begin VB.Frame Frame1 
      BackColor       =   &H0080FF80&
      Caption         =   "Jugador"
      Height          =   495
      Left            =   120
      TabIndex        =   1
      Top             =   0
      Width           =   3135
   End
   Begin VB.TextBox Text3 
      Height          =   285
      Left            =   720
      TabIndex        =   0
      Top             =   720
      Width           =   2535
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Dinero ganado"
      Height          =   375
      Index           =   0
      Left            =   240
      TabIndex        =   21
      Top             =   5040
      Width           =   1695
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Resultado"
      Height          =   375
      Index           =   2
      Left            =   240
      TabIndex        =   17
      Top             =   4560
      Width           =   1695
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Tipo de jugada"
      Height          =   375
      Index           =   1
      Left            =   240
      TabIndex        =   15
      Top             =   4080
      Width           =   1695
   End
   Begin VB.Line Line2 
      BorderWidth     =   2
      X1              =   0
      X2              =   6120
      Y1              =   2520
      Y2              =   2520
   End
   Begin VB.Label Label1 
      BackStyle       =   0  'Transparent
      Caption         =   "Pozo Feliz:"
      Height          =   255
      Index           =   1
      Left            =   360
      TabIndex        =   14
      Top             =   1560
      Width           =   975
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Premio Gordo Progresivo:"
      Height          =   255
      Index           =   1
      Left            =   360
      TabIndex        =   13
      Top             =   2040
      Width           =   1935
   End
   Begin VB.Label Label5 
      BackStyle       =   0  'Transparent
      Caption         =   "Cantidad de fichas a apostar"
      Height          =   375
      Left            =   240
      TabIndex        =   7
      Top             =   3480
      Width           =   1335
   End
   Begin VB.Label Label2 
      BackColor       =   &H00E0E0E0&
      BackStyle       =   0  'Transparent
      Caption         =   "Mesa"
      Height          =   255
      Index           =   0
      Left            =   3840
      TabIndex        =   5
      Top             =   120
      Width           =   495
   End
   Begin VB.Label Label1 
      BackStyle       =   0  'Transparent
      Caption         =   "Valor de la Ficha"
      Height          =   375
      Index           =   0
      Left            =   240
      TabIndex        =   3
      Top             =   3120
      Width           =   1335
   End
   Begin VB.Label Label3 
      BackStyle       =   0  'Transparent
      Caption         =   "Saldo"
      Height          =   255
      Left            =   120
      TabIndex        =   2
      Top             =   720
      Width           =   495
   End
   Begin VB.Line Line1 
      BorderWidth     =   2
      X1              =   0
      X2              =   6120
      Y1              =   1200
      Y2              =   1200
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
