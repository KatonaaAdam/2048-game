#Általános játék leírás
A programmal a 2048 nevezetű játékot lehet játszni, amely indításkor megjelenik a főoldal.A főoldalon 4 pályaméret közül
választhatunk, majd a gombra kattintva elindul a játék, irányítás a →,←,↑,↓ billentyűkkel lehetséges.
 A játék végén, ha nyer vagy veszít a játékos, megjelenik egy'eredmény' nevű gomb, amellyel elmenthetjük
  az adott játékot és megtekinthetjük az eddigi eredményeket. Az adtbázis
az elért szintet és az időt tartalmazza, majd egy gomb hatására visszaugorhatunk a főoldalra.
#Általános program leírás
A projekt a webes technológiákat használ, a controller osztályok az oldalirányításokért felelősek,
a model osztlyban található a dao és annak implementálása, ami az adatbázis műveleteket kezeli, a bean
mappában pedig a modell osztály található.A resource mapppában van az sqlite.db ami a közös adatbázis
az asztali és a webes alkalmazásnak.
A webapp mappában az oldalak kinézetéért felelős css dokumentumok és a a játékfelületek a jsp mappában,
ami html és js segítségével valósítja meg a játékot.
# Beüzemelés
A webes projekt futtatásához be kell állítani a tomcat servert.A 'hu\alkfejl\model\GameDAODBImpl.java'
pedig be kell állítani a 'jdbc:sqlite:D/valami/db/sqlite.db' a saját elérésí útvonalat ahhoz hogy az
adatbázis működni tudjon. A run(Shift+F10)-el pedig futtatjuk a programot .

