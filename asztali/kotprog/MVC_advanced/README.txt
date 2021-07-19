#Általános játék leírás
A programmal a 2048 nevezetű játékot lehet játszni,indítás után megjelenik egy ablak, amelyen 
leírja a lépéseket a játék indításához(1.szint kiválasztás, 2. pályaméret,3. indítás).A játék befejeztével 
megjelenik egy kiírás attól függően, hogy a játékos nyert vagy vesztett. Az 'esc' binnentyű lenyomásával mentjük el 
a játékot az adatbázisba. A kezdőoldalon pedig az eredmények gombra kattintva listázhatjuk az elért szint és időeredményeket.
Az irányításra használatos billentyűk a →,←,↑,↓ valamint a A,D,S,W .

#Általános program leírás
A projekt az MVC sémát követi. A controller osztályban a játékkontroller és a maxszintet kezelő osztályok vannak.A dao
osztályba az adatbázis műveletek kerültek és annak megvalósításai. A modell ostályban a játék model és annak a megvalósítása került.
Az hibákat az utils osztály segítségével jelenítem meg. A view osztályban az ablakkezelő osztályok vannak.
A resource mappában pedig az ablakok fxml-es megvalósításban vannak.

# Beüzemelés
Az adatbázis elérési útvonalát be kell állítani a 'src\main\java\hu\alkfejl\dao\GameDAOImp.java'
ahol a 'jdbc:sqlite:D/valami/sqlite.db' a saját abszolút elérési utvonalra állítjuk, ez az adatbázis a webes
projektben található, de ha véletlen probléma lépne fel, akkor az asztali mappában is van egy db a 
g2048.db evvel is jó kell, hogy legyen.
A futtatáshoz a javafx:run (a plugins menü ablakban a javafx alat) történjen.

