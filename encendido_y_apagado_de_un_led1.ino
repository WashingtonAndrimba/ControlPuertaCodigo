int s1 = 3;
int s2 = 5;
int led = 2;
int a;
int b;
int doorState = 0; 

void setup() {
  pinMode(s1, INPUT);
  pinMode(s2, INPUT);
  pinMode(led, OUTPUT);

  Serial.begin(9600); 
}


void palpiteLed() {
  for (int i = 0; i < 2; i++) {
    digitalWrite(led, HIGH);
    delay(200);
    digitalWrite(led, LOW);
    delay(200);
  }
}

void loop() {
  
  if (Serial.available() > 0) {
    char command = Serial.read(); 

    if (command == '1') {
      digitalWrite(led, HIGH);
    } else if (command == '0') {
      digitalWrite(led, LOW);
    }
  }

  // Leer los estados de los sensores
  a = digitalRead(s1);
  b = digitalRead(s2);

  // Abrir la puerta (encender el LED) cuando se detecte el primer sensor activado
  if (a == HIGH && doorState == 0) {
    digitalWrite(led, HIGH);
    Serial.println("1"); 
    doorState = 1; // Cambiar el estado de la puerta a abierta
  }

  // Cerrar la puerta (apagar el LED) cuando se detecte el segundo sensor activado
  if (b == HIGH && doorState == 1) {
    palpiteLed(); // Hacer que el LED palpite dos veces
    digitalWrite(led, LOW);
    Serial.println("0"); 
    doorState = 0; // Cambiar el estado de la puerta a cerrada
  }
}
