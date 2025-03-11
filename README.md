# ApplicazioneRistorante

### Antipasti:
- Crostini con senape, prosciutto cotto e formaggio
- Quesadilla all'italiana con Asiago
- Omeletta di patate, Trentino-Alto Adige
- Mini canederli con sugo alla puttanesca
- Montanarine
- Gamberi al miele e pan di spezie abbrustolito
- Nuovo antipasto

### Primi Piatti 

## Pappardelle 
Pasta l'uovo con sugo al Cinghiale 
## Lasagna
Pasta all'uovo con carne macinata, uovo e mozzarella
## Gnocchi
Pasta all'uovo con sugo al Ragu'
## Paccheri
Pasta secca con Tartufo e Funghi Porcini
## Spaghetti
Pasta secca con condimento "alla Carbonara"

### Secondi piatti

## Pollo alla cacciatora
Pollo cotto in un sugo di pomodoro, cipolla, aglio, olive nere, capperi, vino rosso, rosmarino.
## Arrosto di vitello
Vitello cotto con rosmarino, salvia, vino bianco e brodo.
## Spezzatino di manzo
Manzo cotto in un sugo di pomodoro, cipolla, vino rosso, brodo, rosmarino e alloro.
## Scaloppine al limone
Vitello in padella con burro, succo di limone, vino bianco e prezzemolo.
## Bistecca alla fiorentina
Bistecca di manzo cotta sulla griglia, servita con olio d'oliva e pepe nero.


## Dessert

### Tiramisù classico
Mascarpone, uova, zucchero, savoiardi, caffè
### Millefoglie alle fragole
Pasta Sfoglia, Zucchero, Fragole, Panna fresca liquida, Zeccheri a velo, Estratto di vaniglia, zucchero a velo
### Babà al rum
Farina Manitoba, Burro, Zucchero, Uova, Lievito di birra fresco, sale fino
### Strudel di mele
Mele Golden, Zucchero, Pangrattato, Burro, Uvetta, Pinoli tostati, Cannella in polvere, Rum, Scorza di limone
### Cannoli siciliani
Ricotta di pecora,  Zucchero, Gocce di cioccolato fondente


### Bevande alcoliche:
- Vino rosso 
- Vino bianco
- Vino rosato
- Prosecco
- Birra

### Bevande analcoliche:
- Acqua naturale
- Acqua frizzante
- Coca-Cola
- Fanta
- Sprite

### Caffè e amari:
- Espresso
- Macchiato
- Ginseng
- Amaro del capo
- Jefferson
- Numero uno


/*Antipasti[] elencoAntipasti = {
        new Antipasti("crostini", "crostini con senape, prosciutto cotto e formaggio", 3, new String[]{"prosciutto cotto", "parmigiano reggiano dop", "fetta di pane", "uova", "senape rustica", "birra trappista triple ale", "amido di mais", "olio extravergine di oliva"}, false),
        new Antipasti("quesadilla", "quesadilla all'italiana con Asiago", 5, new String[]{"asiago dop", "farina messicana di mais bianco precotto", "avocado", "tabasco", "olio extravergine di oliva", "sale"}, true),
        new Antipasti("omelette", "omeletta di patate, Trentino-Alto Adige", 8, new String[]{"patate", "uova", "farina", "olio di arachide", "sale"}, true),
        new Antipasti("canederli", "mini canederli con sugo alla puttanesca", 10, new String[]{"pane multicereali", "latte", "uova", "prezzemolo", "maggiorana", "erba cipollina", "olio di arachide", "sale", "pepe"}, false),
        new Antipasti("montanarine", "montanarine con burrata e salmone affumicato", 15, new String[]{"farina 0", "latte intero", "olio extravergine d'oliva", "lievito di birra", "sale fino", "burrata", "salmone affumicato", "prezzemolo", "pepe rosa in grani"}, false),
};

PrimiPiatti[] primiPiatti = {
        new PrimiPiatti("spaghetti alla carbonara", "spaghetti con uova, guanciale, pecorino romano e pepe nero", 12.00, new String[]{"spaghetti", "uova", "guanciale", "pecorino romano", "pepe nero"}, true),
        new PrimiPiatti("pasta al pesto", "pasta al pesto con pomodori freschi, pinoli e parmigiano", 10.00, new String[]{"pasta", "pesto genovese", "pomodori", "pinoli", "parmigiano reggiano dop"}, false),
        new PrimiPiatti("risotto ai funghi", "risotto con funghi porcini, vino bianco e burrata", 12.00, new String[]{"risotto", "funghi porcini", "vino bianco", "burrata"}, true),
        new PrimiPiatti("tagliatelle al ragù", "tagliatelle con ragù di carne, pomodori e formaggio", 14.00, new String[]{"tagliatelle", "ragù di carne", "pomodori", "formaggio"}, false),
        new PrimiPiatti("pasta alla Norma", "pasta con melanzane fritte, sugo di pomodoro, ricotta salata e basilico", 13.00, new String[]{"pasta", "melanzane", "pomodori", "ricotta salata", "basilico"}, false)
};

SecondiPiatti[] secondiPiatti =  {
        new SecondiPiatti("pollo alla cacciatora", "pollo cotto in un sugo di pomodoro, cipolla, aglio, olive nere, capperi, vino rosso, rosmarino.", 15.00, new String[]{"pollo", "pomodoro", "cipolla", "aglio", "olive nere", "capperi", "vino rosso", "rosmarino"}, true),
        new SecondiPiatti("arrosto di vitello", "vitello cotto con rosmarino, salvia, vino bianco e brodo.", 12.00, new String[]{"vitello", "salvia", "vino bianco", "brodo", "rosmarino"}, true),
        new SecondiPiatti("spezzatino di manzo", "manzo cotto in un sugo di pomodoro, cipolla, vino rosso, brodo, rosmarino e alloro.", 18.00, new String[]{"manzo", "pomodoro", "cipolla", "vino rosso", "brodo", "rosmarino", "alloro"}, true),
        new SecondiPiatti("scaloppine al limone", "vitello in padella con burro, succo di limone, vino bianco e prezzemolo.", 14.00, new String[]{"vitello", "burro", "succo di limone", "vino bianco", "prezzemolo"}, false),
        new SecondiPiatti("bistecca alla fiorentina", "bistecca di manzo cotta sulla griglia, servita con olio d'oliva e pepe nero.", 22.00, new String[]{"manzo", "olio d'oliva", "pepe nero"}, false)
};

Dessert[] elencoDessert = {
        new Dessert("tiramisu", "tiramisu classico italiano", 6.00, new String[]{"mascarpone", "uova", "caffe latte", "cacao in polvere", "zucchero a velo", "savoiardi", "canditi"}, false),
        new Dessert("cheesecake", "cheesecake alla vaniglia con base di biscotti e crema morbida", 7.00, new String[]{"formaggio cremoso", "biscotti digestive", "zucchero", "burro", "vaniglia", "gelatina"}, false),
        new Dessert("cannoli", "cannoli siciliani", 5.00, new String[]{"farina 0", "uova", "zucchero", "lievito di birra", "soro", "sale", "pepe"}, true),
        new Dessert("profiteroles", "bigné ripieni di crema pasticcera e ricoperti da cioccolato fondente", 7.50, new String[]{"farina", "uova", "burro", "zucchero", "latte", "cioccolato fondente", "panna", "vaniglia"}, true),
        new Dessert("crumble di mele", "crumble di mele con un cuore di frutta e croccante copertura di avena e zucchero", 6.50, new String[]{"mele", "zucchero", "burro", "farina", "avena", "cannella"}, true)
};

Bevande[] bevandeAnalcoliche = {
        new Bevande("acqua naturale", "acqua minerale senza gas", 3.0, true),
        new Bevande("acqua frizzante", "acqua minerale con gas", 3.5, true),
        new Bevande("coca-cola", "bibita gassata a base di cola, con un sapore dolce e un retrogusto speziato.", 4.0, true),
        new Bevande("fanta", "bibita dolce e gassata al gusto di arancia", 4.0, true),
        new Bevande("sprite", "bibita dolce gassata al gusto di limone", 4.0, true)
};

Bevande[] bevandeAlcoliche = {
        new Bevande("vino rosso", "vino ottenuto da uve rosse, con fermentazione in contatto con le bucce", 20.0, false),
        new Bevande("vino bianco", "vino prodotto da uve bianche, fermentato senza bucce", 30.0, true),
        new Bevande("vino rosato", "vino ottenuto da uve rosse, con una fermentazione breve in contatto con le bucce", 25.0, true),
        new Bevande("prosecco", "vino spumante prodotto con uve Glera, tipico della zona del Veneto", 15.0, true),
        new Bevande("birra", "bevanda alcolica prodotta dalla fermentazione di malto d'orzo e luppolo", 6.0, true)
};

Bevande[] caffeEAmari = {
        new Bevande("espresso", "caffè preparato con un'alta pressione di acqua calda attraverso il caffè macinato", 0.5, false),
        new Bevande("macchiato", "espresso con una piccola quantità di latte caldo o schiumato", 1.0, false),
        new Bevande("ginseng", "bevanda a base di caffè e estratto di ginseng, con un sapore dolce e speziato", 1.5, false),
        new Bevande("amaro del capo", "amaro calabrese a base di erbe e agrumi", 6.0, true),
        new Bevande("jefferson", "amaro calabrese ricco di erbe, spezie e un retrogusto di agrumi", 6.0, true)
};

menu.aggiungiPortate(secondiPiatti[0]);
menu.aggiungiPortate(secondiPiatti[1]);
menu.aggiungiPortate(secondiPiatti[2]);
menu.aggiungiPortate(secondiPiatti[3]);
menu.aggiungiPortate(secondiPiatti[4]);

menu.aggiungiPortate(bevandeAnalcoliche[0]);
menu.aggiungiPortate(bevandeAnalcoliche[1]);
menu.aggiungiPortate(bevandeAnalcoliche[2]);
menu.aggiungiPortate(bevandeAnalcoliche[3]);
menu.aggiungiPortate(bevandeAnalcoliche[4]);

menu.aggiungiPortate(bevandeAlcoliche[0]);
menu.aggiungiPortate(bevandeAlcoliche[1]);
menu.aggiungiPortate(bevandeAlcoliche[2]);
menu.aggiungiPortate(bevandeAlcoliche[3]);
menu.aggiungiPortate(bevandeAlcoliche[4]);

menu.aggiungiPortate(caffeEAmari[0]);
menu.aggiungiPortate(caffeEAmari[1]);
menu.aggiungiPortate(caffeEAmari[2]);
menu.aggiungiPortate(caffeEAmari[3]);
menu.aggiungiPortate(caffeEAmari[4]);

menu.aggiungiPortate(elencoAntipasti[0]);
menu.aggiungiPortate(elencoAntipasti[1]);
menu.aggiungiPortate(elencoAntipasti[2]);
menu.aggiungiPortate(elencoAntipasti[3]);
menu.aggiungiPortate(elencoAntipasti[4]);

menu.aggiungiPortate(elencoDessert[0]);
menu.aggiungiPortate(elencoDessert[1]);
menu.aggiungiPortate(elencoDessert[2]);
menu.aggiungiPortate(elencoDessert[3]);
menu.aggiungiPortate(elencoDessert[4]);

menu.aggiungiPortate(primiPiatti[0]);
menu.aggiungiPortate(primiPiatti[1]);
menu.aggiungiPortate(primiPiatti[2]);
menu.aggiungiPortate(primiPiatti[3]);
menu.aggiungiPortate(primiPiatti[4]); */

//menu.scriviMenuJson();