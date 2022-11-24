package testing.sqa.tasks;

public class MideTiempos {

   /*Public Module Main
    Dim _desktop As Desktop = Agent.Desktop

    Public Sub Main()

		'Definición de variables
    Dim intDataCounter As Integer
    Dim intCicloInterno As Integer

    intCicloInterno = 10

            'Ingreso desde cartera_barrido PASO 1
            'Segunda fila selecciona lanzar varias veces igual a 1
            _desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("Rueda CONH").Click(MouseButton.Left, New Point(95, 10))
            _desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("TStringGrid").TypeKeys("<Left Ctrl+l>")
		_desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("TbsSkinDBGrid").TypeKeys("<Down><Enter>")
		_desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("CONH  Ofertas para lanzar  Cartera default").Click(MouseButton.Left, New Point(47, 47))
            _desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("TbsSkinDBGrid").TypeKeys("<Down><Application><Down><Down><Down><Down><Down><Down><Down><Enter>")
    With _desktop.Window("Suite SIOPEL  Negociación - Agente V500")
			.Control("1").TypeKeys("<#1><#Enter>")
    End With

		_desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("CONH  Ofertas para lanzar  Cartera default").Click(MouseButton.Left, New Point(680, 7))

            'Tiempo definido en milisegundos
            System.Threading.Thread.Sleep(30000)

            'Ingreso uno a uno PASO 2
    intDataCounter = 1
    Do While intDataCounter <= intCicloInterno
			_desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("Rueda CONH - Fila TBVT15010326 000").Click(MouseButton.Left, New Point(87,6))
            _desktop.Control("TStringGrid").Click(MouseButton.Left, New Point(27, 30))
            _desktop.Control("TStringGrid").TypeKeys("<Insert>")
			_desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("TPanel").TypeKeys("a")
    intDataCounter = intDataCounter + 1
    Loop

		'Tiempo definido en milisegundos
                System.Threading.Thread.Sleep(30000)
                '
                'Ingreso desde cartera_barrido PASO 3
                'Primera fila selecciona lanzar varias veces igual a 10
                _desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("Rueda CONH").Click(MouseButton.Left, New Point(99, 9))
            _desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("TStringGrid").TypeKeys("<Left Ctrl+l>")
		_desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("TbsSkinDBGrid").Click(MouseButton.Right, New Point(47, 24))
            _desktop.Control("Control").Click(MouseButton.Left, New Point(104, 161))

    With _desktop.Window("Suite SIOPEL  Negociación - Agente V500")
			.Control("1").TypeKeys("<#1><#0>")
		    .Control("Ofertas a Lanzar").Control("10").TypeKeys("<Enter>")
    End With


		_desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("CONH  Ofertas para lanzar  Cartera default").Click(MouseButton.Left, New Point(680, 13))
            'Tiempo definido en milisegundos
            System.Threading.Thread.Sleep(15000)


            _desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("TStringGrid").TypeKeys("<F11>")

		'Bajas uno a uno	PASO 4
    intDataCounter = 1
    Do While intDataCounter <= intCicloInterno
			_desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("Rueda CONH - Fila TBVT15010326 000").Click(MouseButton.Left, New Point(87,6))
            _desktop.Control("TStringGrid").TypeKeys("<Delete>")
			_desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("TPanel").TypeKeys("a")
    intDataCounter = intDataCounter + 1

    Loop

		'Modificaciones PASO 5
                _desktop.Control("Rueda CONH - Fila TUVT17230223 000").Click(MouseButton.Left, New Point(87,6))
            _desktop.HorizontalScrollBar("HorizontalScrollBar").Scroll(127)
		_desktop.Control("TStringGrid").Click()
		_desktop.Control("TStringGrid").TypeKeys("+<#Enter>")

    intDataCounter = 1
    Do While intDataCounter <= intCicloInterno
			_desktop.Control("TStringGrid").Click()
			_desktop.Control("TStringGrid").TypeKeys("-<#Enter>")
    intDataCounter = intDataCounter + 1
            'Tiempo definido en milisegundos
            System.Threading.Thread.Sleep(15000)
    Loop

		'Tiempo definido en milisegundos, es 195 segundos
                System.Threading.Thread.Sleep(30000)

                'Bajas masivas PASO 6
                _desktop.Control("Rueda CONH - Fila TUVT17230223 000").Click(MouseButton.Left, New Point(87,6))
            _desktop.Control("TStringGrid").TypeKeys("<Left Ctrl+b>")
    With _desktop.Window("Suite SIOPEL  Negociación - Agente V500")
			.Control("&Yes").TypeKeys("<#Enter>")
    End With

		_desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("Rueda CONH").Click(MouseButton.Left, New Point(128, 16))
            _desktop.Control("V-BRC - Suite SIOPEL  Negociación - Versión 8 20 1").Control("TStringGrid").TypeKeys("<F11>")

    End Sub
    End Module*/
}
