package utils;

import java.awt.Color;

public enum ColorsGUI {

	LETRA_COLOR(new Color(240, 240, 240)),
	GRIS_MUY_OSCURO(new Color(50,50,50)),
	GRIS_OSCURO(new Color(57, 57, 57)),
	GRIS_MENU(new Color(100, 100, 100)), 
	GRIS_SELECCION(new Color(87, 87, 87)),
	GRIS_CLARO(new Color(150,150,150)),
	ERROR_ROJO_CLARO(new Color(255, 192, 203)),
	ROJO(new Color(255,61,61)),
	AMARILLO(new Color(239,255,57)),
	VERDE(new Color(57,255,65)),
	AZUL(new Color(57,160,255)),
	NARANJA(new Color(255, 176, 57));
	
	private Color color;
	
	private ColorsGUI(Color color) {
		this.color = color; 
	}
	
	public Color get() {
		return color; 
	}
}
