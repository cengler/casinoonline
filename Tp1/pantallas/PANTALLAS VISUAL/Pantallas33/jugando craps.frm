VERSION 5.00
Begin VB.Form Form2 
   BackColor       =   &H0080FF80&
   Caption         =   "Jugando Craps"
   ClientHeight    =   6570
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   9495
   LinkTopic       =   "Form2"
   ScaleHeight     =   6570
   ScaleWidth      =   9495
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox Text1 
      BackColor       =   &H0080FF80&
      Height          =   285
      Index           =   2
      Left            =   2400
      TabIndex        =   23
      Text            =   "MONTO"
      Top             =   2040
      Width           =   2775
   End
   Begin VB.CommandButton Command3 
      Caption         =   "Salir del juego"
      Height          =   375
      Left            =   360
      TabIndex        =   21
      Top             =   6120
      Width           =   5175
   End
   Begin VB.TextBox Text2 
      BackColor       =   &H0080FF80&
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   -1  'True
         Strikethrough   =   0   'False
      EndProperty
      Height          =   285
      Index           =   5
      Left            =   1800
      TabIndex        =   19
      Text            =   "DINERO"
      Top             =   5640
      Width           =   1815
   End
   Begin VB.TextBox Text2 
      BackColor       =   &H0080FF80&
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   -1  'True
         Strikethrough   =   0   'False
      EndProperty
      Height          =   285
      Index           =   2
      Left            =   1800
      TabIndex        =   17
      Text            =   "TIPO DE JUGADA"
      Top             =   4680
      Width           =   1815
   End
   Begin VB.TextBox Text2 
      BackColor       =   &H0080FF80&
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   -1  'True
         Strikethrough   =   0   'False
      EndProperty
      Height          =   285
      Index           =   0
      Left            =   1800
      TabIndex        =   15
      Text            =   "RESULTADO"
      Top             =   5160
      Width           =   1815
   End
   Begin VB.CommandButton Command2 
      Caption         =   "Tirar los dados"
      Height          =   375
      Left            =   360
      TabIndex        =   14
      Top             =   4200
      Width           =   3255
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Apostar"
      Height          =   375
      Left            =   360
      TabIndex        =   13
      Top             =   3720
      Width           =   3255
   End
   Begin VB.ListBox List1 
      Height          =   2985
      Left            =   3840
      TabIndex        =   12
      Top             =   2880
      Width           =   1695
   End
   Begin VB.ComboBox Combo2 
      Height          =   315
      Left            =   1800
      TabIndex        =   10
      Top             =   3240
      Width           =   1815
   End
   Begin VB.ComboBox Combo1 
      Height          =   315
      Left            =   1800
      TabIndex        =   8
      Top             =   2760
      Width           =   1815
   End
   Begin VB.TextBox Text3 
      BackColor       =   &H0080FF80&
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   -1  'True
         Strikethrough   =   0   'False
      EndProperty
      Height          =   285
      Left            =   720
      TabIndex        =   3
      Text            =   "SALDO"
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
   Begin VB.TextBox Text1 
      BackColor       =   &H0080FF80&
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   -1  'True
         Strikethrough   =   0   'False
      EndProperty
      Height          =   285
      Index           =   0
      Left            =   4320
      TabIndex        =   1
      Text            =   "NRO MESA"
      Top             =   120
      Width           =   1215
   End
   Begin VB.TextBox Text1 
      BackColor       =   &H0080FF80&
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   -1  'True
         Strikethrough   =   0   'False
      EndProperty
      Height          =   285
      Index           =   1
      Left            =   1440
      TabIndex        =   0
      Text            =   "MONTO"
      Top             =   1560
      Width           =   3735
   End
   Begin VB.Image Image1 
      Height          =   6345
      Left            =   5640
      Picture         =   "jugando craps.frx":0000
      Stretch         =   -1  'True
      Top             =   120
      Width           =   3735
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Premio Gordo Progresivo:"
      Height          =   255
      Index           =   1
      Left            =   360
      TabIndex        =   22
      Top             =   2040
      Width           =   1935
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Dinero ganado"
      Height          =   375
      Index           =   3
      Left            =   360
      TabIndex        =   20
      Top             =   5640
      Width           =   1335
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Tipo de jugada"
      Height          =   255
      Index           =   3
      Left            =   360
      TabIndex        =   18
      Top             =   4680
      Width           =   1095
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Resultado"
      Height          =   255
      Index           =   2
      Left            =   360
      TabIndex        =   16
      Top             =   5160
      Width           =   1095
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Apuestas realizadas"
      Height          =   375
      Index           =   2
      Left            =   3840
      TabIndex        =   11
      Top             =   2640
      Width           =   1695
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Seleccionar monto:"
      Height          =   495
      Index           =   1
      Left            =   360
      TabIndex        =   9
      Top             =   3240
      Width           =   1215
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Seleccionar tipo de apuesta:"
      Height          =   495
      Index           =   0
      Left            =   360
      TabIndex        =   7
      Top             =   2760
      Width           =   1215
   End
   Begin VB.Line Line1 
      BorderWidth     =   2
      X1              =   0
      X2              =   5520
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
      BackColor       =   &H00E0E0E0&
      BackStyle       =   0  'Transparent
      Caption         =   "Mesa"
      Height          =   255
      Index           =   0
      Left            =   3480
      TabIndex        =   5
      Top             =   120
      Width           =   495
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
      X2              =   5520
      Y1              =   2520
      Y2              =   2520
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
