#ifndef Error404Cham_H
#define Error404Cham_H

void Set_Cham_Color(int color);

void Disable_Cham();

void Enable_Antena_Head();

void Disable_Antena_Head();

struct {
	int red = 0;
	int green = 1;
	int blue = 2;
	int white = 3;
	int black = 4;
	int purpleSense = 5;
	int yellow = 6;
	int magenta = 7;
	int gray = 8;

	void set_red() {
		Set_Cham_Color(red);
	}

	void set_green() {
		Set_Cham_Color(green);
	}

	void set_blue() {
		Set_Cham_Color(blue);
	}

	void set_white() {
		Set_Cham_Color(white);
	}

	void set_black() {
		Set_Cham_Color(black);
	}

	void set_purpleSense() {
		Set_Cham_Color(purpleSense);
	}

	void set_yellow() {
		Set_Cham_Color(yellow);
	}

	void set_magenta() {
		Set_Cham_Color(magenta);
	}

	void set_gray() {
		Set_Cham_Color(gray);
	}
} bruno_chams;

#endif
