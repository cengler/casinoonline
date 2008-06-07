VERSION 5.00
Begin VB.Form Form2 
   BackColor       =   &H0080FF80&
   Caption         =   "Tragamonedas"
   ClientHeight    =   6480
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   9420
   LinkTopic       =   "Form2"
   ScaleHeight     =   6480
   ScaleWidth      =   9420
   StartUpPosition =   3  'Windows Default
   Begin VB.CommandButton Command2 
      Caption         =   "Salir del juego"
      Height          =   375
      Left            =   240
      TabIndex        =   8
      Top             =   5880
      Width           =   4455
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Apostar"
      Height          =   375
      Left            =   2760
      TabIndex        =   7
      Top             =   3600
      Width           =   1935
   End
   Begin VB.ComboBox Combo2 
      Height          =   315
      Left            =   1680
      TabIndex        =   6
      Top             =   3600
      Width           =   615
   End
   Begin VB.ComboBox Combo1 
      Height          =   315
      Left            =   1680
      TabIndex        =   3
      Top             =   3120
      Width           =   2055
   End
   Begin VB.Frame Frame1 
      BackColor       =   &H0080FF80&
      Caption         =   "Jugador"
      Height          =   615
      Left            =   120
      TabIndex        =   0
      Top             =   0
      Width           =   3135
      Begin VB.Label Label8 
         BackStyle       =   0  'Transparent
         Caption         =   "NOMBRE JUGADOR"
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
         Left            =   600
         TabIndex        =   23
         Top             =   240
         Width           =   2295
      End
   End
   Begin VB.Image Image1 
      Height          =   2715
      Left            =   5040
      Picture         =   "TRAGAM~1.frx":0000
      Stretch         =   -1  'True
      Top             =   3360
      Width           =   3825
   End
   Begin VB.Line Line2 
      BorderWidth     =   2
      X1              =   0
      X2              =   9120
      Y1              =   2760
      Y2              =   2760
   End
   Begin VB.Label Label13 
      BackStyle       =   0  'Transparent
      BorderStyle     =   1  'Fixed Single
      Caption         =   "DINERO GANADO"
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
      Left            =   1680
      TabIndex        =   22
      Top             =   5160
      Width           =   2295
   End
   Begin VB.Label Label12 
      BackStyle       =   0  'Transparent
      BorderStyle     =   1  'Fixed Single
      Caption         =   "RES 3"
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
      Index           =   2
      Left            =   3360
      TabIndex        =   21
      Top             =   4680
      Width           =   615
   End
   Begin VB.Label Label12 
      BackStyle       =   0  'Transparent
      BorderStyle     =   1  'Fixed Single
      Caption         =   "RES 2"
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
      Index           =   1
      Left            =   2520
      TabIndex        =   20
      Top             =   4680
      Width           =   615
   End
   Begin VB.Label Label12 
      BackStyle       =   0  'Transparent
      BorderStyle     =   1  'Fixed Single
      Caption         =   "RES 1"
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
      Index           =   0
      Left            =   1680
      TabIndex        =   19
      Top             =   4680
      Width           =   615
   End
   Begin VB.Label Label11 
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
      Left            =   2400
      TabIndex        =   18
      Top             =   2040
      Width           =   2895
   End
   Begin VB.Label Label10 
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
      TabIndex        =   17
      Top             =   1560
      Width           =   3735
   End
   Begin VB.Label Label9 
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
      Left            =   720
      TabIndex        =   16
      Top             =   840
      Width           =   2535
   End
   Begin VB.Label Label7 
      BackStyle       =   0  'Transparent
      BorderStyle     =   1  'Fixed Single
      Caption         =   "NRO MESA"
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
      Left            =   7560
      TabIndex        =   15
      Top             =   240
      Width           =   1695
   End
   Begin VB.Label Label6 
      BackStyle       =   0  'Transparent
      BorderStyle     =   1  'Fixed Single
      Caption         =   "TIPO DE JUGADA"
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
      Left            =   1680
      TabIndex        =   14
      Top             =   4200
      Width           =   2055
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Dinero ganado"
      Height          =   375
      Index           =   0
      Left            =   240
      TabIndex        =   13
      Top             =   5160
      Width           =   1695
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Resultado"
      Height          =   375
      Index           =   2
      Left            =   240
      TabIndex        =   12
      Top             =   4680
      Width           =   1695
   End
   Begin VB.Label Label4 
      BackStyle       =   0  'Transparent
      Caption         =   "Tipo de jugada"
      Height          =   375
      Index           =   1
      Left            =   240
      TabIndex        =   11
      Top             =   4200
      Width           =   1695
   End
   Begin VB.Label Label1 
      BackStyle       =   0  'Transparent
      Caption         =   "Pozo Feliz:"
      Height          =   255
      Index           =   1
      Left            =   360
      TabIndex        =   10
      Top             =   1680
      Width           =   975
   End
   Begin VB.Label Label2 
      BackStyle       =   0  'Transparent
      Caption         =   "Premio Gordo Progresivo:"
      Height          =   255
      Index           =   1
      Left            =   360
      TabIndex        =   9
      Top             =   2160
      Width           =   1935
   End
   Begin VB.Label Label5 
      BackStyle       =   0  'Transparent
      Caption         =   "Cantidad de fichas a apostar"
      Height          =   375
      Left            =   240
      TabIndex        =   5
      Top             =   3600
      Width           =   1335
   End
   Begin VB.Label Label2 
      BackColor       =   &H00E0E0E0&
      BackStyle       =   0  'Transparent
      Caption         =   "Mesa"
      Height          =   255
      Index           =   0
      Left            =   6960
      TabIndex        =   4
      Top             =   240
      Width           =   495
   End
   Begin VB.Label Label1 
      BackStyle       =   0  'Transparent
      Caption         =   "Valor de la Ficha"
      Height          =   375
      Index           =   0
      Left            =   240
      TabIndex        =   2
      Top             =   3240
      Width           =   1335
   End
   Begin VB.Label Label3 
      BackStyle       =   0  'Transparent
      Caption         =   "Saldo"
      Height          =   255
      Left            =   120
      TabIndex        =   1
      Top             =   840
      Width           =   495
   End
   Begin VB.Line Line1 
      BorderWidth     =   2
      X1              =   0
      X2              =   9120
      Y1              =   1320
      Y2              =   1320
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
