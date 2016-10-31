# Software Engineering (Master) - WS2016

*Gruppe "Abteilung für Profiarbeit"*

## 2. Übung

### 2.1

UML Diagramm
![](diagram.png)

### 2.4

Die folgende Spezifikation beschreibt die Gedankengänge der Modellverarbeitung eines Schiffe-Versenken-Spielfeldes durch den Codegenerator `CodeGen.java`.
Das, dem Spielfeld zugrunde liegende, M1 Modell darf nicht leer sein.
Es besteht aus *Zeilen*, wobei jede Zeile einer Zeile des Spielfeldes entspricht.
Das Modell darf höchstens 26 Zeilen (A-Z) enthalten.
Jede Zeile besteht aus *Zellen* und muss die gleiche Anzahl an Zellen aufweisen.
Jede Zeile darf maximal 9 Zellen enthalten und muss durch einen Umbruch beendet werden.
Eine *Zelle* muss aus einer der Ziffern 0 oder 1 bestehen.