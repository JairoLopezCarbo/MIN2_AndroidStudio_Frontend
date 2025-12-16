IMPORTANTE ACORDARSE DE CARGAR LA BASE DE DATOS PARA PODER CREAR EL USUARIO, EL BOTON ESTA EN EL MENU DESPUES DE LOGEARS, MUESTRA UNA LISTA DE TU EQUIPO INCLUIDO A TI MISMO.
SI NO PERTENECES A UN EQUIPO DONDE EL TEXTVIEW DEL TEAM PONDRA NONE. 

EJ2
● Muye (G4)
● Wenjie (G3)
● Jairo (G1)
● Pol (G5)
● Erik (G2)
Tareas
Nueva funcionalidad que permita consultar a los miembros del equipo del que forma parte.
(Ver EJ1)
● T1. En la aplicación Android, se debe añadir una nueva actividad que proporcione un
listado de los usuarios (imagen, nombre, puntos) que comparten equipo con él
mismo.
● T2. Nueva ruta en el backend que reciba la nueva consulta
GET /user/xxxx/team
=======>
{
team: “porxinos”
members: [
{
‘name’: ‘Juan’
‘avatar’:'https://cdn.pixabay.com/photo/2017/07/11/15/51/kermit-2493979_1280.png',
‘points’: 250
},
{
‘name’: ‘Palomo’
‘avatar’: ‘..’,
‘points”: 200
},
]
}
