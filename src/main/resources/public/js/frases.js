// https://github.com/goolord/alpha-nvim/blob/main/lua/alpha/fortune.lua
// +sA+""+pA
const sA = " <br/><br/><span style='float:right'>-"
const pA = " </span>"
const frasesVida = [
    "Un salario es la droga que tu patron te da para olvidar tus sueños"
      +sA+"Bill Gates"+pA,
    "Si sigues esperando el momento adecuado, desperdiciaras toda tu vida y no pasara nada."
      +sA+"Bill Gates"+pA,
    "Perderas el 99% de tus amigos cercanos si comienzas a mejorar tu vida."
      +sA+"Bill Gates"+pA,
    "Nadie viene a salvar tus problemas, tu vida es cien porciento tu responsabilidad."
      +sA+"Bill Gates"+pA,
    "Entrenate para dejar que la gente gane discusiones a proposito para conservar tu salud mental."
      +sA+"Bill Gates"+pA,
    "Te vuelves mas maduro cuando te entrenas para no tomarte nada personal."
      +sA+"Bill Gates"+pA,
    "No necesitas mas de cien libros de autoayuda, todo lo que necesitas es accion mas el cien de autodisciplina."
      +sA+"Bill Gates"+pA,
    "Habilidades y educacion financiera te haran conquistar al noventa y siete por ciento de los graduados universitarios."
      +sA+"Bill Gates"+pA,
    "Me tomo nueve años aprender esto, pero te lo mostrare en un minuto."
      +sA+"Bill Gates"+pA,
    "Nunca tengas relaciones sexuales con una mujer que esta apegada a ti, eventualmente ella rompera los platos en tu cabeza algun dia."
      +sA+"Mark Twain"+pA,
    "El matrimonio es como meter la mano en una bolsa de serpientes con la esperanza de sacar una anguila."
      +sA+"Leonardo da Vinci"+pA,
    "Si una chica te engaño, espera hasta que el destino la castigue."
      +sA+"Leonardo da Vinci"+pA,
    "Cuando ocurre algo malo, bebes para olvidarlo; si ocurre algo bueno, bebes para celebrarlo; y si no pasa nada, tambien bebes para que pase algo."
      +sA+"Charles Bukowski"+pA,
    "Por supuesto que es posible amar a otra persona si no la conoces demasiado."
      +sA+"Charles Bukowski"+pA,
    "Deje de buscar a la chica de mis sueños, solo queria una que no fuera una pesadilla."
      +sA+"Charles Bukowski"+pA,
    "Quien quiere sexo te habla de todo, pero no de sexo."
      +sA+"Charles Bukowski"+pA,
    "Siempre hay una mujer que te salva de otra y, mientras te salva, se prepara para destruirte."
      +sA+"Charles Bukowski"+pA,
    "Quien, contrariamente al Consejo de sus amigos, se caso con una ramera, pronto conocera toda su mala moral."
      +sA+"Marco Aurelio"+pA,
    "Las batallas contra las mujeres son las unicas que se ganan huyendo."
      +sA+"Napoleon"+pA,
    "Solo hay dos palancas que muevan a los hombres: el miedo y el interes"
      +sA+"Napoleon"+pA,
    "Nada tan dificil como decidirse."
      +sA+"Napoleon"+pA,
    "Una cabeza sin memoria es como una fortaleza sin guarnicion"
      +sA+"Napoleon"+pA,
    "La mejor politica es hacer creer a los hombres que son libres"
      +sA+"Napoleon"+pA,
    "El hombre carece de amigos; es su buena fortuna quien los tiene."
      +sA+"Napoleon"+pA,
    "Una mujer que ries es una mujer conquistada"
      +sA+"Napoleon"+pA,
    "El metodo mas seguro para permanecer pobre es ser honrado"
      +sA+"Napoleon"+pA,
    "Si un hombre dice que eres el mejor, significa que sabe que no encontrara a un tonto asi."
      +sA+"Napoleon"+pA,
    "Cuando una mujer quiere sexo, siempre habla de sus ex amantes."
      +sA+"Sigmund Freud"+pA,
    "Las mujeres necesitamos la belleza para que los hombres nos amen, y la estupidez para que nosotras amemos a los hombres."
      +sA+"Coco Chanel"+pA,
    "No hay nada peor que la soledad. La soledad puede ayudar a un hombre a realizarse, pero destruye a una mujer."
      +sA+"Coco Chanel"+pA,
    "El amor es un estado de psicosis temporal."
      +sA+"Coco Chanel"+pA,
    "Si quieres que tu esposa te escuche, entonces habla con otra mujer; ella sera todo oidos."
      +sA+"Coco Chanel"+pA,
    "El que ama, se hace humilde. Aquellos que aman, por decirlo de alguna manera, renuncian a una parte de su narcisismo."
      +sA+"Coco Chanel"+pA,
    "La madurez es la capacidad de posponer la gratificacion."
      +sA+"Coco Chanel"+pA,
    "Sin amor caemos enfermos."
      +sA+"Coco Chanel"+pA,
    "Quien carece de sexo habla de sexo, el hambriento habla de comida, quien no tiene dinero de dinero, y nuestros oligarcas y banqueros hablan de moralidad."
      +sA+"Coco Chanel"+pA,
    "Si quieres conocer los defectos de la chica, elogiala delante de tus amigos."
      +sA+"Benjamin Franklin"+pA,
    "Si quieres ser amado, ama y se adorable."
      +sA+"Benjamin Franklin"+pA,
    "Entre su amante y su esposa, un hombre siempre elige la libertad."
      +sA+"Proverbio japones"+pA,
    "Si le tienes miedo a la soledad, no te cases."
      +sA+"Anton Chejov"+pA,
    "A un hombre inteligente le gusta aprender, a un tonto le gusta enseñar."
      +sA+"Anton Chejov"+pA,
    "La vida no se trata de encontrarte a ti mismo. La vida es sobre crearte a ti mismo."
      +sA+"Bernard Shaw"+pA,
    "El odio es la venganza del cobarde por haber sido intimidado."
      +sA+"Bernard Shaw"+pA,
    "Libertad significa responsabilidad. Es por eso que la mayoria de los hombres lo temen."
      +sA+"Bernard Shaw"+pA,
    "La pasion sexual es la causa de la guerra y el fin de la paz, es el fundamento de lo que es serio y, en consecuencia, la concentracion de todo deseo."
      +sA+"Schopenhauer"+pA,
    "La felicidad consiste en la repeticion frecuente del placer"
      +sA+"Schopenhauer"+pA,
    "La forma mas segura de no ser muy miserable es no esperar ser muy feliz."
      +sA+"Schopenhauer"+pA,
    "El que no disfruta de la soledad, no amara a la libertad."
      +sA+"Schopenhauer"+pA,
    "Los mejores, mas variados y duraderos placeres, son los de la mente."
      +sA+"Schopenhauer"+pA,
    "Lo que la gente comunmente llama destino es, por regla general, nada mas que su propia conducta estupida y tonta."
      +sA+"Schopenhauer"+pA,
    "La religion es la metafisica de las masas. "
      +sA+"Schopenhauer"+pA,
    "Las religiones son como las luciernagas. Necesitand de la oscuridad para brillar."
      +sA+"Schopenhauer"+pA,
    "La fe es como el amor: No puede ser impuesta por la fuerza."
      +sA+"Schopenhauer"+pA,
    "La vida sin dolor no tiene sentido."
      +sA+"Schopenhauer"+pA,
    "Estas solo no porque nadie te necesite, sino porque tu mismo te consideras indigno de amor."
      +sA+"Schopenhauer"+pA,
    "Sobre todo, es la perdida lo que nos enseña el valor de las cosas."
      +sA+"Schopenhauer"+pA,
    "Envidiar es tonto porque nadie es realmente digno de envidia."
      +sA+"Schopenhauer"+pA,
    "Lo que ahora hace que las personas sean sociables es su incapacidad para soportar la soledad y, por tanto, a si mismas."
      +sA+"Schopenhauer"+pA,
    "Las mujeres se casan esperando que los hombres cambien. Los hombres se casan esperando que las mujeres no cambien nunca. Ambos se decepcionan."
      +sA+"Albert Einstein"+pA,
    "Cuando te cases debes preguntarte si seras capaz de conversar con esa persona en tu vejez. Todo lo demas en el matrimonio es transitorio."
      +sA+"Friedrich Nietzsche"+pA,
    "Una mujer puede establecer una buena amistad con un hombre, pero para que esto dure debe estar acompañado de un poco de antipatia fisica."
      +sA+"Friedrich Nietzsche"+pA,
    "Si una mujer quiere sexo siempre lo consigue."
      +sA+"Friedrich Nietzsche"+pA,
    "La esperanza es el peor de los males, pues prolonga el tormento del hombre."
      +sA+"Friedrich Nietzsche"+pA,
    "Buscar la felicidad en la fe es no querer buscar la verdad."
      +sA+"Friedrich Nietzsche"+pA,
    "Lo que no te mata te hara mas fuerte."
      +sA+"Friedrich Nietzsche"+pA,
    "El sexo no es mas que una trampa de la naturaleza para no extinguirnos."
      +sA+"Friedrich Nietzsche"+pA,
    "Negar la existencia de Dios sera la unica salvacion del mundo."
      +sA+"Friedrich Nietzsche"+pA,
    "La valia de un hombre se mide por la cuantia de soledad que aguanta."
      +sA+"Friedrich Nietzsche"+pA,
    "El hombre, en su orgullo, creo a Dios a su imagen y semejanza."
      +sA+"Friedrich Nietzsche"+pA,
    "Donde no puedas amar, pasa de largo."
      +sA+"Friedrich Nietzsche"+pA,
    "No tienes sexo no porque nadie te quiera, sino porque te consideras indigno de amor y afecto."
      +sA+"Friedrich Nietzsche"+pA,
    "Puedes manipular facilmente a un hombre, dandole mucho sexo y limitando completamente su respuesta final."
      +sA+"Iris Murdoch"+pA,
    "El matrimonio es una especie de lavado de cerebro, que obliga a la aceptacion de muchisimos horrores."
      +sA+"Iris Murdoch"+pA,
    "El que no se contenta con lo que tiene, no estara contento con lo que le gustaria tener."
      +sA+"Socrates"+pA,
    "A partir de los deseos mas profundos, vienen a menudo los odios mas mortales."
      +sA+"Socrates"+pA,
    "El hombre que no piensa sino en vivir, no vive."
      +sA+"Socrates"+pA,
    "El deseo sexual es el primer paso hacia la iluminacion."
      +sA+"Socrates"+pA,
    "No hagas nada que sea vergonzoso, ni en presencia de nadie ni en secreto, Sea tu primera leu... respetarte a ti mismo."
      +sA+"Socrates"+pA,
    "Solo es util el conocimiento que nos hace mejores."
      +sA+"Socrates"+pA,
    "Que si has de casarte me preguntas. Yo te respondo: haz lo que quieras. Pues hagas lo que hagas, te arrepentiras."
      +sA+"Socrates"+pA,
    "Cambia de placeres, pero no cambies de amigos."
      +sA+"Voltaire"+pA,
    "El trabajo nos ahorra tres males: el aburrimiento, el vicio y la necesidad."
      +sA+"Voltaire"+pA,
    "La decision mas importante que hacer es estar en un buen estado de animo."
      +sA+"Voltaire"+pA,
    "Si una dama dice que no, significa que tal vez; si dice 'tal vez' significa 'si'; si dice que si, no es una dama."
      +sA+"Voltaire"+pA,
    "Es por tu propia felicidad por lo que necesitas a la persona que amas."
      +sA+"Ayn Rand"+pA,
    "Una mujer obtiene mas placer sexual haciendo trampa que un hombre; para el no es un Dios sabe que evento; para ella, hacer trampa siempre significa venganza, o pasion, o pecado."
      +sA+"Ayn Rand"+pA,
    "Lo unico que las mujeres no perdonan es la traicion."
      +sA+"Garcia Marquez"+pA,
    "La peor forma de extrañar a alguien, es estar sentado a su lado y saber que nunca lo podras tener."
      +sA+"Garcia Marquez"+pA,
    "El poder de deseos incumplidos es la raiz de esclavitud de todo hombre."
      +sA+"Paramahansa Yogananda"+pA,
    "Ser esclavizado por el sexo, es perder todo lo que el hombre necesita para ser feliz."
      +sA+"Paramahansa Yogananda"+pA,
    "Si deseas ser feliz, tienes que desear ver a otros felices tambien."
      +sA+"Sabiduria hindu"+pA,
    "Un hombre inteligente nunca se casara con una mujer inteligente"
      +sA+"Sabiduria hindu"+pA,
    "La vejez empieza cuando los recuerdos pesan mas que las esperanzas"
      +sA+"Sabiduria hindu"+pA,
    "El amor es la meta, la vida es el viaje."
      +sA+"Osho"+pA,
    "La vida comienza donde el miedo termina."
      +sA+"Osho"+pA,
    "Una mujer debe ser amada, no entendida. Ese es el primer entendimiento."
      +sA+"Osho"+pA,
    "Amar y deseo son dos cosas diferentes."
      +sA+"Miguel de Cervantes"+pA,
    "No desees y seras el hombre mas rico del mundo."
      +sA+"Miguel de Cervantes"+pA,
    "La falta de sexo a largo plazo eventualmente convierte a una persona en neurotica."
      +sA+"Miguel de Cervantes"+pA,
    "Puede haber amor si celos, pero no sin temores."
      +sA+"Miguel de Cervantes"+pA,
    "No ames lo que eres, sino lo que puedes llegar a ser."
      +sA+"Miguel de Cervantes"+pA,
    "La ingratitud es hija de la soberbia."
      +sA+"Miguel de Cervantes"+pA,
    "Todo lo que nos irrita de los demas puede llevarnos a comprendernos a nosotros mismos."
      +sA+"Carl Gustav Jung"+pA,
    "Conocer tu propia oscuridad es el mejor metodo para lidiar con las tinieblas de otras personas."
      +sA+"Carl Gustav Jung"+pA,
    "Hasta que hagas consciente al inconsciente, este dirigira tu vida y lo llamaras destino."
      +sA+"Carl Gustav Jung"+pA,
    "Donde esta tu miedo, ahi esta tu tarea."
      +sA+"Carl Gustav Jung"+pA,
    "Un hombre que no ha pasado por el infierno de sus pasiones nunca las ha superado."
      +sA+"Carl Gustav Jung"+pA,
    "No retengas a quien se aleja de ti. Porque asi no llegara quien desea acercarse."
      +sA+"Carl Gustav Jung"+pA,
    "Quien mira afuera, sueña; quien mira adentro, se despierta."
      +sA+"Carl Gustav Jung"+pA,
    "Si no ha tenido relaciones sexuales durante mucho tiempo, inevitablemente encontrara nerviosismo, un colapso de la fuerza y la apatia."
      +sA+"Carl Gustav Jung"+pA,
    "Se necesita muy poco para destruir a una persona: simplemente necesitas convencerlo de que nadie necesita lo que el hace."
      +sA+"Dostoyevski"+pA,
    "No llenes tu memoria con los rencores, para que no te quedes sin espacio para los momentos hermosos."
      +sA+"Dostoyevski"+pA,
    "El hombre lo tiene todo en sus manos, y todo se le escapa por cobardia."
      +sA+"Dostoyevski"+pA,
    "Nada en este mundo es mas dificil que decir la verdad, nada mas facil que la adulacion."
      +sA+"Dostoyevski"+pA,
    "Los celosos son los primeros que perdonan, todas las mujeres lo saben."
      +sA+"Dostoyevski"+pA,
    "Ofrecer amistad a quien pide amor, es como dar pan a quien muere de sed."
      +sA+"Bob Marley"+pA,
    "Las mujeres siempre traicionan a los hombres que las acusan de traicion."
      +sA+"Bob Marley"+pA,
    "Hay que ser osado con las mujeres. De cada diez veces, una se logra triunfar."
      +sA+"Stendhal"+pA,
    "Dinero compartido aumenta el amor, dinero regalado lo mata."
      +sA+"Stendhal"+pA,
    "Mi opinion sintetica de las mujeres es que con ellas es preciso atreverse a todo."
      +sA+"Stendhal"+pA,
    "Con las pasiones uno no se aburre jamas; sin ellas se idiotiza."
      +sA+"Stendhal"+pA,
    "En la soledad se puede adquirir todo, menos el caracter."
      +sA+"Stendhal"+pA,
    "No se lo que es el corazon. Solo utilizo tal palabra para referirme a las flaquezas de la mente."
      +sA+"Marques de Sade"+pA,
    "Debemos aplicar violencia al objeto de nuestro deseo. Asi, cuando se rinda, el placer sera mayor."
      +sA+"Marques de Sade"+pA,
    "La verdadera felicidad yace en los sentidos, y la virtud no satisface ninguno de ellos."
      +sA+"Marques de Sade"+pA,
    "Lo que hace celoso al amante no es el afecto que siente por ella, sino el miedo a la humillacion publica si su querida cambiara de sentimientos hacia el."
      +sA+"Marques de Sade"+pA,
    "El sexo sin dolor es como la comida sin sabor."
      +sA+"Marques de Sade"+pA,
    "El unico camino para conquistar el corazon de una mujer es a traves del tormento. No conozco otro tan seguro."
      +sA+"Marques de Sade"+pA,
    "El hombre tiene que estimular el animo y el espiritu de la mujer para hacer el sexo interesnte. El verdadero amante es el hombre que la emociona al tocarle la cabeza, sonreir o mirarla a los ojos."
      +sA+"Marilyn Monroe"+pA,
    "La amistad se convierte en amor con frecuencia, pero el amor nunca pasa a ser amistad."
      +sA+"Lord Byron"+pA,
    "Nunca ames a alguien que te trata como si fueses normal y corriente."
      +sA+"Oscar Wilde"+pA,
    "Cuando un hombre hace exactamente lo que una mujer espera que haga, ella no piensa mucho en el. Siempre hay que hacer lo que una mujer no espera, al igual que hay que decir lo que ella no entiende."
      +sA+"Oscar Wilde"+pA,
    "Las mujeres siempre traicionan si les falta atencion."
      +sA+"Proverbios Indios"+pA,
    "El que cuenta las historias gobierna el mundo."
      +sA+"Proverbios Indios"+pA,
    "No te comprometas con una mujer que no tiene un plan porque te daras cuenta de que si ella no va a ninguna parte, tarde o temprano tu tambien estaras dando tumbos."
      +sA+"Leo Tolstoi"+pA,
    "El hombre que pregunta es un tonto por un minuto, el que no pregunta es un tonto de por vida."
      +sA+"Confucio"+pA,
    "Actua con amabilidad pero no esperes gratitud"
      +sA+"Confucio"+pA,
    "No debemos hablar nunca ni bien ni mal de nosotros mismos; bien, porque no nos creerian, y mal, porque lo creerian facilmente."
      +sA+"Confucio"+pA,
    "Nunca establezcas una amistad con un hombre que no sea mejor que tu mismo."
      +sA+"Confucio"+pA,
    "Si odias a una persona significa que te ha derrotado."
      +sA+"Confucio"+pA,
    "Cuando te des cuenta de que lo que haces a otro, te lo haces a ti, habras entendido una gran verdad."
      +sA+"Lao Tse"+pA,
    "El habito que te mantiene pobre e infeliz es no ser exigente con tu tiempo."
      +sA+"Lao Tse"+pA,
    "Una mujer querrá tener sexo contigo si le cuentas sobre su falta de atractivo. Ella definitivamente querra demostrarte todo lo contrario."
      +sA+"Honore de Balzac"+pA,
    "Las mujeres necesitan el amor para tener sexo, y los hombres necesitan el sexo para amar."
      +sA+"Citas"+pA,
    "La unica manera de influir en otra persona es hablar sobre lo que quiere y mostrarle como obtenerlo."
      +sA+"Dale Carnegie"+pA,
    "Solo el conocimiento que se usa queda grabado en tu mente"
      +sA+"Dale Carnegie"+pA,
    "Mantente ocupado. Es el tipo de medicamento mas barato que existe."
      +sA+"Dale Carnegie"+pA,
    "Haz lo que temes hacer y sigue haciendolo, esa es la forma mas rapida y segura jamas descubierta de vencer al miedo."
      +sA+"Dale Carnegie"+pA,
    "El exito es conseguir lo que quieres. La felicidad es quere lo que obtienes."
      +sA+"Dale Carnegie"+pA,
    "Una mujer con hijos solo te querra a ti por 2 cosas: la primera es que busca asegurar el patrimonio y bienestar de ella y sus infantes, y segundo puede que en realidad te ame y no este interesada por desfalcar tus bienes."
      +sA+"Dale Carnegie"+pA,
    "Cuida tus pensamientos porque se volveran palabras.</br>"+
      "Cuida tus palabras porque se volveran actos.</br>"+
      "Cuida tus actos porque se volveran habitos.</br>"+
      "Cuida tus habitos porque forjaran tu caracter.</br>"+
      "Cuida tu caracter porque formara tu destino.</br>"+
      "Y tu destino sera tu vida..."
      +sA+"Gandi"+pA,
    "no te aman por quien eres, sino por lo que las haces sentir",
    "para el beta inventan reglas, con el alfa las rompen ",
    "no es tuya, es solo tu turno",
    "las mujeres buscan un hombre de mayor valor que ella",
    "las mujeres escuchan con sus emociones y no con la razón",
    "tratala como una celebridad, y ella te tratara como un simple fan",
    "no te enfoques es una sola mujer, ellas no lo hacen tampoco",
    "no le demuestres alto interés ni tus emociones",
    "si te enfocas en ti, ellas también lo harán",
    "nunca líderes con tu cartera, lidera con tu carisma y masculinidad (dejala que ella sólita se entere de tu billetera)",
    "Las circunstancias estan mas alla del control humano, pero nuestra conducta esta en nuestro propio poder."
      +sA+"Benjamin Disraeli"+pA,
    "Iniciativa es hacer lo correcto sin que a uno se lo digan"
      +sA+"Victor Hugo"+pA,
    "La ley controla al hombre mas debil. La conducta correcta controla al mas grande."
      +sA+"Mark Twain"+pA,
    "Recordad que de la conducta de cada uno depende el destino de todos"
      +sA+"Alejandro Magno"+pA,
];
const frasesCumple = [
    "Feliz cumpleaños pero, ¿no habías cumplido ya suficientes el año pasado?",
    "Si no te regalo nada este año no te ofendas, estoy ahorrando para el próximo. ¡Feliz cumpleaños!",
    "No estás envejeciendo, solo te haces más vintage.",
    "¡Cómo se te ocurre cumplir años en tiempos de crisis!",
    "Feliz cumpleaños, ríe y sonríe mientras puedas, que tus dientes tienen fecha de caducidad.",
    "Solo pareces un año mayor que en tu último cumpleaños. Felicidades.",
    "Felicidades, sé optimista, el año que viene será peor.",
    "Con un mechero no nos llega, necesitamos un lanzallamas para encender todas tus velas de cumpleaños. ¡Felicidades!",
    "No te preocupes por tu edad, igual dentro de poco no podrás recordarla.",
    "¿Piensas que ser mayor es algo divertido? Espera a verte en el espejo para que te rías con ganas. ¡Feliz Cumpleaños!",
    "Espero que celebres tu cumpleaños tal y como lo hiciste con el primero: desnudo.",
    "Felicidades: cada año estás más cerca de dejar de mentir sobre tu edad, ya será muy evidente.",
    "¡A partir de ahora tienes una arruga más! ¡Feliz cumpleaños!",
    "Si no puedes leer a simple vista lo que dice esta carta, no te compliques, a tu edad los detalles son lo de menos. ¡¡Feliz Cumpleaños!!",
    "Dentro de cada persona mayor hay una persona más joven preguntándose: ¿Qué diablos ha pasado? ¡Felicidades!",
    "No mientas nunca sobre tu edad, salvo en casos de emergencia, como cuando por ejemplo alguien te pregunte por los años que tienes. ¡Feliz cumpleaños!",
    "Abracémonos ahora mismo, antes de que te des cuenta de que no hay ningún regalo. ¡Feliz cumpleaños!",
    "Cuanto más viejo es el violinista, más dulce es la melodía. Feliz cumpleaños al que está en el violín."
];
const frasesLigar = [
    "Dime cómo te llamas y te pido para los Reyes.",
    "¿Tienes un diccionario? Me he quedado sin palabras al verte.",
    "Hola, ¿en qué parada debo bajarme para empezar a gustarte?",
    "¿Acabamos de subir al Hogwarts Express? Porque parece que nos dirigimos a un lugar mágico.",
    "Me recomiendan 9 de 10 hombres (el otro es mi ex).",
    "Necesito tu contraseña de NETFLIX.",
    "Eres como un correo de Hacienda: me aceleras el pulso.",
    "Dime ya si te gusto o no, para saber si pago el gym o el Netflix.",
    "Tus ojos son como IKEA. Estoy totalmente perdida en ellos.",
    "¿Eres electricista? Porque definitivamente acabas de iluminarme el día.",
    "Ni en los laboratorios existe tanta química como la que hay entre nosotros.",
    "Me gustas más que dormir hasta tarde.",
    "Mi fantasía textual es que me comas y punto.",
    "No soy un perro, pero 'guau' contigo.",
    "Are you a sofa? Because you are sofackingg precious.",
    "Creo que mi móvil está roto, ¿puedes probar a llamarme?",
    "Si vas a estar en mi cabeza todo el día, al menos ponte ropa.",
    "Espero que sepas primeros auxilios, porque me has dejado sin respiración.",
    "En realidad no soy así de alto. Estoy sentado sobre mi cartera.",
    "Si las miradas pudieran matar, serías un arma de destrucción masiva.",
    "¿Te llamas WiFi? Porque realmente estoy sintiendo una conexión.",
    "¡Si tú y yo fuéramos calcetines, haríamos una gran pareja.",
    "¿Eres un préstamo bancario? ¡Porque tienes todo mi interés!",
    "Si yo fuese tú, estaría conmigo.",
    "Te sigo porque tenemos que seguir nuestros sueños.",
    "Tengo NETFLIX.",
    "Te quiero dar más fuerte que Will Smith a Chris Rock.",
    "Sabes que me gusta el café, pero hoy prefiero tener té.",
    "No contestaré a esa pregunta sin la presencia de mi abogado, que temo poder perder el juicio por ti.",
    "Soy mala en matemáticas, pero creo que haríamos buena suma.",
    "Seguramente no soy la persona más guapa del local, pero soy la única que se ha atrevido a hablarte.",
    "No sé lo que somos, pero no quiero que nunca lo dejemos de ser",
    "Parece que soy Google, solo me buscas cuando quieres algo.",
    "Quién fuera bizco para verte 2 veces.",
    "Oye, ¿te presentas a las elecciones? Porque eres un partidazo.",
    "He decidido gastar la batería de mi móvil contigo.",
    "Te invito al cine. Al menos si no te gusto habrás visto una buena peli.",
    "Estoy escribiendo una novela. Si me das tu número del móvil te la mando.",
    "Mi madre opina que deberías casarnos.",
    "Perdón, es que soy ecologista y quiero plantarte unos besos.",
    "Voy a estudiar Derecho para dar con el caso que no me haces.",
];
const risasDelDia = [
    "¡Sé feliz hoy! Aunque únicamente sea por joder a los envidiosos.",
    "Todo es divertido, siempre y cuando le ocurra a otra persona.",
    "Siembra un árbol y harás feliz a un perro.",
    "Ahí afuera hay un mundo mejor, pero es carísimo.",
    "No tengo insomnio, tengo conexión a Internet.",
    "Ojos que no ven... amigas que te lo cuentan todo.",
    "Lo malo no es vivir en las nubes, sino bajar.",
    "Comer chocolates encoge la ropa.",
    "Tu ignorancia es enciclopédica.",
    "Lo importante no es ganar, es hacer perder a los demás.",
    "Creía que se podría y se pudrió.",
    "No hacer nada es difícil, nunca se sabe cuando terminas.",
    "Si no puedes convencerlos, confúndelos.",
    "Odio que hablen cuando interrumpo.",
    "Dile a tu orgullo que el mío le manda saludos.",
    "El interior es lo que cuesta.",
    "El mundo es un pañuelo y tú eres un moco.",
    "Mi billetera es como una cebolla, abrirla me hace llorar.",
    "Gracias a Dios que soy ateo.",
    "El tiempo sin ti es empo.",
    "La inteligencia me persigue, pero yo soy más rápido.",
    "Tengo que ir al oculista, pero nunca veo el momento.",
    "Me hago responsable de lo que digo, no de lo que entiendas.",
    "Si el mundo es un pañuelo, ¿nosotros qué somos?",
    "Más vale tarde, porque por la mañana duermo.",
    "No soy vago, estoy en modo ahorro de energía.",
    "Si tengo que hacer la colada, que sea de piña, por favor.",
    "Odio ser bipolar, es una sensación fantástica.",
    "La vida es dura. Después de todo, te mata.",
    "Suelo cocinar con vino, a veces incluso se lo agrego a la comida.",
    "Un día sin sol es, ya sabes, de noche.",
    "No te hagas ilusiones, hazte unas mechas.",
    "Enamorarse está bien, pero mejor es comer croquetas.",
    "Si lo que deseas no viene a ti, usa el plan ve.",
    "Estado civil: Cansada.",
    "Yo ¿rara? Qué va, soy una: Edición limitada.",
    "La vida es bella. Los feos sois vosotros.",
    "Me voy a hacer un trío… Mi almohada, mi cama y yo.",
    "¿Felicidad? Felicidad es ver una señal de wifi sin contraseña.",
    "Lo importante no es saber, sino tener el teléfono del que sabe.",
    "Nada está perdido... hasta que tu madre no puede encontrarlo.",
    "Si tienes que forzarlo, no es tu talla.",
    "La nevera es un buen ejemplo de que lo mejor está en el interior.",
    "Estado en reparación por falta de imaginación.",
    "No hay suficientes días en el fin de semana.",
    "Hay dos palabras que te abrirán muchas puertas: 'tire y empuje'.",
    "Puede que no sea Alicia, pero sí soy una maravilla.",
    "La vida es muy corta para estar enamorándose de lo común.",
    "Las princesas también se cansan de tanto cuento.",
    "Si la vida te da limones, pide sal y tequila.",
    "– Amor, ¿te importo? – ¿A qué país?",
    "No te hagas ilusiones, hazte unas mechas.",
    "Si la montaña viene hacia ti…¡corre! Es un derrumbe.",
    "Malvados kilos, salgan de este cuerpo atlético.",
    "¡Trágame tierra! Pero escúpeme en Las Bahamas.",
    "Si se muere una pulga, ¿a dónde va? Al pulgatorio.",
    "Teorema del vago: Lo intento, pero no lo hago.",
    "Pórtate mal, pásalo bien, elimina las pruebas y niégalo todo.",
    "¡Corre a por tus sueños! Si no los alcanzas, por lo menos haces deporte.",
    "Si buscas una mano que te ayude... ¡Búscala al final de tu brazo!",
    "La vida es corta. Sonríe mientras tengas dientes.",
    "Si no me acuerdo, no pasó.",
    "Uno nunca valora lo que tiene hasta que llega mamá y dice: “¿Lo quieres o lo tiro?”",
    "Anoche entró un ladrón en casa, buscaba dinero, me levanté de la cama y nos pusimos a buscar los dos.",
    "Has venido a ser feliz, no te distraigas.",
    "Hay dos palabras que te abrirán muchas puertas: Tire y Empuje.",
    "Solía pensar que soy indeciso, pero ahora no estoy seguro.",
    "Lo más cerca que una persona llega a la perfección es el día que rellena una solicitud de empleo.",
    "No te tomes la vida en serio. Nunca saldrás vivo de ella.",
    "Previsión del tiempo para esta noche: estará oscuro.",
    "Las mejores cosas de la vida te deshacen el pelo.",
    "Le pregunté a mi perro: “¿Cómo me veo?” Y me dijo: “Guau.” Por eso lo amo tanto.",
    "No soporto ver la casa sucia. Ahora mismo me levanto y apago la luz.",
    "Las mejores cosas de la vida engordan.",
    "Amo la dieta, por eso voy a dejarla ir: si regresa es mía, si no, nunca lo fue.",
    "Mucha gente se siente confundida cuando una frase no termina de la manera que ellos salchicha.",
    "Ojos que no ven, fregonazo que te pegas.",
    "Todos quieren que les pase algo bonito en la vida. ¡Pero yo no puedo estar pasando por todos lados!",
    "Yo tenía un lado dulce... hasta que me lo comí.",
    "El silencio es oro. A menos que tengas hijos, ahí se convierte en sospecha.",
    "Una conciencia limpia es por lo general, una señal de mala memoria.",
    "No todas las obras de arte están en museos, por ejemplo, yo estoy en mi casa.",
    "Tropecé tantas veces con la misma cuerda que saqué una melodía.",
    "Si al principio no tienes éxito, entonces el paracaidismo definitivamente no es para ti.",
    "Dejar de fumar es lo más fácil del mundo. Lo sé porque lo he hecho miles de veces.",
    "Nunca dejes para mañana lo que puedas hacer pasado mañana.",
    "Cuando la vida te da limones, arrójaselos a alguien a los ojos.",
    "Sólo hay dos cosas infinitas: el universo y la estupidez humana. Y no estoy tan seguro de la primera.",
    "Entras a tu cuarto, miras a tu cama, tu cama te mira a ti… amor a primera vista.",
    "Siempre recuerda que tú eres único. Absolutamente igual que todos los demás.",
];
const frasesDelDia = [
    "La única forma de hacer un gran trabajo es amar lo que haces."+sA+"Steve Jobs"+pA,
    "El futuro pertenece a quienes creen en la belleza de sus sueños." + sA + "Eleanor Roosevelt"+pA,
    "La vida es lo que pasa mientras estás ocupado haciendo otros planes."+sA+"John Lennon"+pA,
    "Sé el cambio que quieres ver en el mundo."+sA+"Mahatma Gandhi"+pA,
    "La imaginación es más importante que el conocimiento. "+ sA+"Albert Einstein"+pA,
    "Calcula el orden de tus algoritmos.<br/>"+
      " Hazte una idea del tiempo que probablemente te llevara, antes de escribir el código."+sA+""+pA,
    "Depurar es dos veces más difícil que escribir el código en primer lugar"+
      "<br/> Por lo tanto, si escribes el código de la forma más inteligente posible, por definición, no eres lo suficientemente inteligente como para depurarlo."+
      sA+"Brian Kernighan"+pA,
    "Si no terminas, solo estás ocupado, no eres productivo. ",
    "Adaptar programas antiguos para que funcionen en máquinas nuevas suele significar adaptar las máquinas nuevas para que funcionen como las antiguas."+
      +sA+"Alan Perlis"+pA,
    "Los necios ignoran la complejidad.<br/>"+
      "Los pragmáticos la soportan.<br/>"+
      "Algunos pueden evitarla.<br/>"+
      "Los genios la eliminan"+
       +sA+"Alan Perlis"+pA,
    "Es más fácil cambiar las especificaciones para adaptarlas al programa que al revés."+
      +sA+"Alan Perlis"+pA,
    "La simplicidad no precede a la complejidad, sino que la sigue."+
      +sA+"Alan Perlis"+pA,
    "La optimización obstaculiza la evolución."+
      +sA+"Alan Perlis"+pA,
    "La recursividad es la raíz del cálculo, ya que intercambia descripción por tiempo."+
      +sA+"Alan Perlis"+pA,
    "Es mejor tener 100 funciones que operan sobre una estructura de datos que 10 funciones sobre 10 estructuras de datos."+
      +sA+"Alan Perlis"+pA,
    "No hay nada tan inútil como hacer con gran eficiencia algo que no debería hacerse en absoluto."
     +sA+"Peter Drucker"+pA,
    "Si no fracasas al menos el 90 % de las veces, es que no estás apuntando lo suficientemente alto."+
     +sA+"Alan Kay"+pA,
    "Creo que a muchos programadores noveles les gusta utilizar estructuras de datos avanzadas y funciones avanzadas del lenguaje como forma de demostrar su capacidad.<br/>"+
      "Yo lo llamo el síndrome del domador de leones.<br/>"+
      "Estas demostraciones son impresionantes, pero, a menos que se traduzcan en beneficios reales para el proyecto, es mejor evitarlas.<br/>"+
      +sA+"Glyn Williams"+pA,
    "Prefiero morir de pasión que de aburrimiento."+
      +sA+"Vincent Van Gogh"+pA,
    "Si un sistema debe servir al espíritu creativo, debe ser totalmente comprensible para un solo individuo.",
    "El principal reto del informático es no dejarse confundir por las complejidades que él mismo ha creado."+
      +sA+"Edsger W. Dijkstra"+pA,
    "El progreso en un contexto fijo es casi siempre una forma de optimización.<br/>"+
      " Los actos creativos no suelen permanecer en el contexto en el que se producen."+
      +sA+"Alan Kay"+pA,
    "La esencia del XML es la siguiente: el problema que resuelve no es difícil, y no lo resuelve bien."+
      +sA+"Phil Wadler"+pA,
    "Un buen programador es alguien que siempre mira a ambos lados antes de cruzar una calle de sentido único."+
      +sA+"Doug Linder"+pA,
    "Los patrones significan «Me he quedado sin lenguaje."+
      +sA+"Rich Hickey"+pA,
    "Siempre programa como si la persona que acabara manteniendo tu código fuera un psicópata violento que sabe dónde vives."+
      +sA+"John Woods"+pA,
    "Unix no fue diseñado para impedir que sus usuarios hicieran tonterías, ya que eso también les impediría hacer cosas inteligentes. ",
    "Contrariamente a la creencia popular, Unix es fácil de usar.<br/>"+
      " Simplemente es muy selectivo a la hora de elegir con quién decide hacerse amigo. ",
    "La perfección se alcanza, no cuando no hay nada más que añadir, sino cuando no hay nada más que quitar. ",
    "Hay dos formas de crear un diseño de software: una es hacerlo tan sencillo que no haya deficiencias evidentes, y la otra es hacerlo tan complicado que no haya deficiencias evidentes."+
      +sA+"C.A.R. Hoare"+pA,
    "Si no cometes errores, es que no estás trabajando en problemas lo suficientemente difíciles."+
      +sA+"Frank Wilczek"+pA,
    "Si no empiezas con una especificación, cada fragmento de código que escribes es un parche."+
      +sA+"Leslie Lamport"+pA,
    "Las cachés son errores en potencia."+
      +sA+"Rob Pike"+pA,
    "La abstracción no tiene que ver con la vaguedad, sino con ser preciso en un nuevo nivel semántico."+
      +sA+"Edsger W. Dijkstra"+pA,
    "dd es horrible a propósito.<br/> Es una broma sobre OS/360 JCL.<br/> Pero hoy en día es una broma estandarizada internacionalmente.<br/> Creo que eso lo dice todo."+
      +sA+"Rob Pike"+pA,
    "Todos los bucles son infinitos para los módulos RAM defectuosos.",
    "Todas las expresiones idiomáticas deben aprenderse.<br/>"+
      " Las buenas expresiones idiomáticas solo hay que aprenderlas una vez."+
      +sA+"Alan Cooper"+pA,
    "Para que una tecnología tenga éxito, la realidad debe prevalecer sobre las relaciones públicas, ya que no se puede engañar a la naturaleza."+
      +sA+"Richard Feynman"+pA,
    "Si los programadores fueran electricistas, los programadores paralelos serían expertos en desactivación de bombas.<br/>"+
      " Ambos cortan cables."+
      +sA+"Bartosz Milewski"+pA,
    "Los ordenadores son más difíciles de mantener a gran altitud.<br/>"+
      " El aire más enrarecido reduce el amortiguamiento entre los cabezales y los platos del disco.<br/>"+
      " Además, hay más radiación.",
    "Casi todos los lenguajes de programación están sobrevalorados por quienes los utilizan."+
      +sA+"Larry Wall"+pA,
    "Los algoritmos sofisticados son lentos cuando n es pequeño, y n suele ser pequeño."+
      +sA+"Rob Pike"+pA,
    "Los métodos son simplemente funciones con un primer argumento especial."+
      +sA+"Andrew Gerrand"+pA,
    "Preocúpate por tu oficio.<br/>"+
      " ¿Por qué dedicar tu vida a desarrollar software si no te importa hacerlo bien?",
    "Ofrece opciones, no pongas excusas poco convincentes.<br/>"+
      " En lugar de excusas, ofrece opciones.<br/>"+
      " No digas que no se puede hacer; explica lo que se puede hacer.",
    "Se un catalizador del cambio.<br/>"+
      " No se puede forzar el cambio en las personas.<br/>"+
      " En lugar de eso, muéstrales cómo podría ser el futuro y ayúdalas a participar en su creación.",
    "Haga de la calidad una cuestión de requisitos.<br/>"+
      " Involucre a sus usuarios en la determinación de los requisitos de calidad reales del proyecto.",
    "Analiza críticamente lo que lees y escuchas.<br/>"+
      " No te dejes influir por los vendedores, el bombo mediático o los dogmas.<br/>"+
      " Analiza la información en función de ti y de tu proyecto",
    "DRY: no te repitas.<br/>"+
      " Cada elemento de conocimiento debe tener una representación única, inequívoca y autorizada dentro de un sistema.",
    "Elimina los efectos entre elementos no relacionados.<br/>"+
      " Diseña componentes autónomos, independientes y con un único propósito bien definido.",
    "Utiliza balas trazadoras para encontrar el objetivo.<br/>"+
      " Las balas trazadoras te permiten localizar tu objetivo probando diferentes cosas y viendo lo cerca que caen.",
    "Programa cerca del ámbito del problema», «Diseña y programa en el lenguaje de tus usuarios».",
    "Repite el calendario con el código.<br/>"+
      " Utiliza la experiencia que adquieras a medida que implementas para perfeccionar los plazos del proyecto",
    "Utiliza el poder de los shells de comandos.<br/>"+
      " Utiliza el shell cuando las interfaces gráficas de usuario no sean suficientes",
    "Utiliza siempre el control del código fuente.<br/> El control del código fuente es una máquina del tiempo para tu trabajo: puedes volver atrás.",
    "No te asustes al depurar.<br/> Respira hondo y ¡PIENSA! en qué podría estar causando el error.",
    "No lo des por sentado, demuéstralo.<br/> Demuestra tus suposiciones en el entorno real, con datos reales y condiciones límite.",
    "Escribe código que escriba código.<br/> Los generadores de código aumentan tu productividad y ayudan a evitar la duplicación.",
    "Diseña con contratos.<br/> Utiliza contratos para documentar y verificar que el código no hace más ni menos de lo que dice hacer",
    "Utiliza aserciones para evitar lo imposible.<br/> Las aserciones validan tus suposiciones.<br/> Úsalas para proteger tu código de un mundo incierto.",
    "Termina lo que empiezas.<br/> Siempre que sea posible, la rutina u objeto que asigna un recurso debe ser responsable de desasignarlo.",
    "Configura, no integres.<br/> Implementa las opciones tecnológicas para una aplicación como opciones de configuración, no a través de la integración o la ingeniería.",
    "Analiza el flujo de trabajo para mejorar la concurrencia.<br/> Aprovecha la concurrencia en el flujo de trabajo de tus usuarios.",
    "Diseña siempre pensando en la concurrencia.<br/> Si permites la concurrencia, diseñarás interfaces más limpias con menos suposiciones.",
    "Utiliza pizarras para coordinar el flujo de trabajo.<br/> Utiliza pizarras para coordinar hechos y agentes dispares, manteniendo al mismo tiempo la independencia y el aislamiento entre los participantes.",
    "Estima el orden de tus algoritmos.<br/> Hazte una idea de cuánto tiempo pueden tardar las cosas antes de escribir el código.",
    "Refactoriza pronto y a menudo.<br/><br/>"+
      " Al igual que podrías desbrozar y reorganizar un jardín, reescribe, reelabora y rediseña el código cuando sea necesario.<br/>"+
      " Soluciona la raíz del problema.",
    "Prueba tu software o lo harán tus usuarios.<br/>"+
      " Prueba sin piedad.<br/> No dejes que tus usuarios encuentren los errores por ti.",
    "No recopiles requisitos, búscalos.<br/>"+
      " Los requisitos rara vez se encuentran en la superficie.<br/>"+
      " Están enterrados bajo capas de suposiciones, conceptos erróneos y políticas.",
    "Las abstracciones duran más que los detalles.<br/>"+
      " Invierte en la abstracción, no en la implementación.<br/>"+
      " Las abstracciones pueden sobrevivir al aluvión de cambios de diferentes implementaciones y nuevas tecnologías.",
    "No pienses fuera de la caja, encuentra la caja.<br/> Cuando te enfrentes a un problema imposible, identifica las limitaciones reales.<br/> Pregúntate: «¿Tiene que hacerse así? ¿Tiene que hacerse?.",
    "Algunas cosas es mejor hacerlas que describirlas.<br/> No caigas en la espiral de las especificaciones: en algún momento tienes que empezar a programar.",
    "Las herramientas caras no producen mejores diseños.<br/> Ten cuidado con la publicidad exagerada de los proveedores, los dogmas del sector y el aura del precio.<br/> Juzga las herramientas por sus méritos.",
    "No utilices procedimientos manuales.<br/> Un script de shell o un archivo por lotes ejecutará las mismas instrucciones, en el mismo orden, una y otra vez.",
    "La codificación no termina hasta que se ejecutan todas las pruebas.<br/> No hay más que decir.",
    "Prueba la cobertura del estado, no la cobertura del código.<br/> Identifique y pruebe los estados significativos del programa.<br/> No basta con probar las líneas de código.",
    "El inglés es solo un lenguaje de programación.<br/> Escriba los documentos como escribiría el código: respete el principio DRY, utilice metadatos, MVC, generación automática, etc.",
    "Supere ligeramente las expectativas de sus usuarios.<br/> Comprenda las expectativas de sus usuarios y luego ofrézcales un poco más.",
    "Piensa en tu trabajo.<br/> Desactiva el piloto automático y toma el control.<br/> Critica y evalúa constantemente tu trabajo.",
    "No convivas con ventanas rotas».<br/> «Corrija los malos diseños, las decisiones erróneas y el código deficiente cuando los vea.",
    "Recuerda el panorama general.<br/> No te obsesiones tanto con los detalles que te olvides de mirar lo que ocurre a tu alrededor.",
    "Invierte regularmente en tu cartera de conocimientos.<br/>Haz del aprendizaje un hábito.",
    "Importa tanto lo que dices como cómo lo dices.<br/> No sirve de nada tener grandes ideas si no las comunicas de forma eficaz.",
    "Facilita la reutilización.<br/> Si es fácil reutilizar, la gente lo hará.<br/> Crea un entorno que favorezca la reutilización.",
    "No hay decisiones definitivas.<br/> Ninguna decisión es inamovible.<br/> En su lugar, considera cada una como si estuviera escrita en la arena de la playa y planifica el cambio.",
    "Crea prototipos para aprender.<br/> Crear prototipos es una experiencia de aprendizaje.<br/> Su valor no reside en el código que produces, sino en las lecciones que aprendes.",
    "Haz estimaciones para evitar sorpresas.<br/> Haz estimaciones antes de empezar.<br/> Detectarás posibles problemas desde el principio.",
    "Guarda el conocimiento en texto plano.<br/> El texto plano no quedará obsoleto.<br/> Te ayuda a aprovechar tu trabajo y simplifica la depuración y las pruebas.",
    "Utiliza bien un único editor.<br/> El editor debe ser una extensión de tu mano; asegúrate de que tu editor sea configurable, extensible y programable.",
    "Soluciona el problema, no busques culpables.<br/> No importa si el error es culpa tuya o de otra persona: sigue siendo tu problema y hay que solucionarlo.",
    "select no está roto».<br/> Es raro encontrar un error en el sistema operativo o en el compilador, o incluso en un producto o biblioteca de terceros.<br/> Lo más probable es que el error esté en la aplicación.",
    "Aprende un lenguaje de manipulación de texto.<br/> Pasas gran parte del día trabajando con texto.<br/> ¿Por qué no dejar que el ordenador haga parte del trabajo por ti?",
    "No se puede escribir software perfecto.<br/> El software no puede ser perfecto.<br/> Protege tu código y a tus usuarios de los errores inevitables.",
    "Falla pronto.<br/> Un programa muerto normalmente causa mucho menos daño que uno dañado.",
    "Utiliza excepciones para problemas excepcionales.<br/> Las excepciones pueden sufrir todos los problemas de legibilidad y mantenibilidad del clásico código espagueti.<br/> Reserva las excepciones para cosas excepcionales.",
    "Minimiza el acoplamiento entre módulos.<br/> Evita el acoplamiento escribiendo código «tímido» y aplicando la Ley de Deméter.",
    "Pon las abstracciones en el código y los detalles en los metadatos.<br/> Programa para el caso general y pon los detalles fuera de la base de código compilada.",
    "Diseña utilizando servicios.<br/> Diseña en términos de objetos concurrentes e independientes de los servicios, detrás de interfaces bien definidas y coherentes.",
    "Separa las vistas de los modelos.<br/> Gana flexibilidad a bajo coste diseñando tu aplicación en términos de modelos y vistas.",
    "No programes por casualidad.<br/> Confía solo en cosas fiables.<br/> Ten cuidado con la complejidad accidental y no confundas una coincidencia afortunada con un plan intencionado.",
    "Prueba tus estimaciones.<br/> El análisis matemático de los algoritmos no lo dice todo.<br/> Intenta cronometrar tu código en su entorno de destino.",
    "Diseña para probar.<br/> Empieza a pensar en las pruebas antes de escribir una línea de código.",
    "No utilices código de asistente que no entiendas.<br/> Los asistentes pueden generar montones de código.<br/> Asegúrate de entenderlo todo antes de incorporarlo a tu proyecto.",
    "Trabaja con un usuario para pensar como un usuario.<br/> Es la mejor manera de comprender cómo se utilizará realmente el sistema.",
    "Utiliza un glosario del proyecto.<br/> Crea y mantén una única fuente con todos los términos y vocabulario específicos de un proyecto.",
    "Empieza cuando estés listo.<br/> Has estado acumulando experiencia toda tu vida.<br/> No ignores las dudas molestas.",
    "No seas esclavo de los métodos formales.<br/> No adoptes ciegamente ninguna técnica sin ponerla en el contexto de tus prácticas y capacidades de desarrollo.",
    "Organiza los equipos en función de la funcionalidad.<br/> No separes a los diseñadores de los programadores, ni a los probadores de los modeladores de datos.<br/> Crea equipos del mismo modo que creas código.",
    "Prueba pronto.<br/> Prueba con frecuencia.<br/> Prueba automáticamente.<br/> Las pruebas que se ejecutan con cada compilación son mucho más efectivas que los planes de prueba que se quedan en un cajón.",
    "Utiliza saboteadores para probar tus pruebas.<br/> Introduce errores a propósito en una copia separada del código fuente para verificar que las pruebas los detectan.",
    "Encuentra los errores una sola vez.<br/> Una vez que un probador humano encuentra un error, debería ser la última vez que un probador humano encuentra ese error.<br/> Las pruebas automáticas deben comprobarlo a partir de ese momento.",
    "Firma tu trabajo.<br/>Los artesanos de épocas anteriores se enorgullecían de firmar sus obras.<br/> Tú también deberías hacerlo.",
    "Piensa dos veces, programa una vez.",
    "No importa lo lejos que hayas llegado por el camino equivocado, da media vuelta ahora mismo.",
    "¿Por qué nunca tenemos tiempo para hacerlo bien, pero siempre tenemos tiempo para volver a hacerlo?",
    "Semanas de programación pueden ahorrarte horas de planificación.",
    "Iterar es humano, recurrir es divino."+
      +sA+"L. Peter Deutsch"+pA,
    "Los ordenadores son inútiles.<br/> Solo pueden darte respuestas."+
      +sA+"Pablo Picasso"+pA,
    "La pregunta de si los ordenadores pueden pensar es como preguntarse si los submarinos pueden nadar."+
      +sA+"Edsger W. Dijkstra"+pA,
    "Es ridículo vivir 100 años y solo ser capaz de recordar 30 millones de bytes.<br/>"+
      " Ya sabes, menos que un disco compacto.<br/> La condición humana se está volviendo cada vez más obsoleta."+
      +sA+"Marvin Minsky"+pA,
    "¿Te lo ha dicho el ordenador central de la ciudad? R2D2, ¡sabes muy bien que no hay que fiarse de un ordenador extraño!"+
      +sA+"C3PO"+pA,
    "La mayoría del software actual se parece mucho a una pirámide egipcia con millones de ladrillos apilados unos encima de otros, sin integridad estructural, sino construida a base de fuerza bruta y miles de esclavos."+
      +sA+"Alan Kay"+pA,
    "Por fin he aprendido lo que significa «compatible con versiones anteriores».<br/> Significa que podemos conservar todos nuestros viejos errores."+
      +sA+"Dennie van Tassel"+pA,
    "Hay dos productos importantes que salen de Berkeley: el LSD y UNIX.<br/> No creemos que sea una coincidencia."+
      +sA+"Jeremy S. Anderson"+pA,
    "La mayor parte de las patentes son una mierda.<br/> Perder el tiempo leyéndolas es una estupidez.<br/> Es responsabilidad del propietario de la patente hacerlo y hacerlas cumplir."+
      +sA+"Linus Torvalds"+pA,
    "Controlar la complejidad es la esencia de la programación informática."+
      +sA+"Brian Kernighan"+pA,
    "La complejidad mata.<br/> Agota a los desarrolladores, dificulta la planificación, la creación y las pruebas de los productos, plantea retos de seguridad y causa frustración a los usuarios finales y a los administradores."+
      +sA+"Ray Ozzie"+pA,
    "La función de un buen software es hacer que lo complejo parezca sencillo."+
      +sA+"Grady Booch"+pA,
    "Hay una vieja historia sobre una persona que deseaba que su ordenador fuera tan fácil de usar como su teléfono.<br/> Ese deseo se ha hecho realidad, ya que ya no sé cómo usar mi teléfono."+
      +sA+"Bjarne Stroustrup"+pA,
    "Solo hay dos industrias que se refieren a sus clientes como usuarios: la de las drogas ilegales y la del software."+
      +sA+"Edward Tufte"+pA,
    "La mayoría de ustedes están familiarizados con las virtudes de un programador.<br/> Hay tres, por supuesto: pereza, impaciencia y arrogancia."+
      +sA+"Larry Wall"+pA,
    "La enseñanza de la informática no puede convertir a nadie en un programador experto, del mismo modo que estudiar pinceles y pigmentos no puede convertir a nadie en un pintor experto."+
      +sA+"Eric S. Raymond"+pA,
    "El optimismo es un riesgo laboral de la programación; la retroalimentación es el tratamiento."+
      +sA+"Kent Beck"+pA,
    "Primero, resuelve el problema.<br/> Luego, escribe el código"+
      +sA+"John Johnson"+pA,
    "Medir el progreso de la programación por líneas de código es como medir el progreso de la construcción de un avión por su peso."+
      +sA+"Bill Gates"+pA,
    "No te preocupes si no funciona bien.<br/> Si todo funcionara, te quedarías sin trabajo. - Ley de Mosher sobre ingeniería de software",
    "Un programador LISP conoce el valor de todo, pero el coste de nada."+
      +sA+"Alan J. Perlis"+pA,
    "Todos los problemas de la informática se pueden resolver con otro nivel de indirección."+
      +sA+"David Wheeler"+pA,
    "Las funciones retrasan la vinculación; las estructuras de datos la inducen.<br/>"+
      " Moraleja: estructura los datos al final del proceso de programación."+
      +sA+"Alan J. Perlis"+pA,
    "Las cosas fáciles deben ser fáciles y las difíciles deben ser posibles."+
      +sA+"Larry Wall"+pA,
    "No hay nada más permanente que una solución temporal",
    "Si no puedes explicarle algo a un niño de seis años, es que realmente tú tampoco lo entiendes."+
      +sA+"Albert Einstein"+pA,
    "Toda programación es un ejercicio de almacenamiento en caché."+
      +sA+"Terje Mathisen"+pA,
    "El software es difícil."+
      +sA+"Donald Knuth"+pA,
    "No sabían que era imposible, ¡así que lo hicieron!"+
      +sA+"Mark Twain"+pA,
    "El modelo orientado a objetos facilita la creación de programas por acumulación.<br/> En la práctica, esto suele significar que proporciona una forma estructurada de escribir código espagueti."+
      +sA+"Paul Graham"+pA,
    "Pregunta: ¿Cómo es posible que un gran proyecto de software se retrase un año? Respuesta: ¡Un día tras otro!",
    "El primer 90 % del código representa el primer 90 % del tiempo de desarrollo.<br/> El 10 % restante del código representa el otro 90 % del tiempo de desarrollo."+
      +sA+"Tom Cargill"+pA,
    "En el ámbito del software, rara vez tenemos requisitos significativos.<br/> Incluso si los tenemos, la única medida de éxito que importa es si nuestra solución resuelve la idea cambiante que tiene el cliente de cuál es su problema."+
      +sA+"Jeff Atwood"+pA,
    "Si la depuración es el proceso de eliminar errores, entonces la programación debe ser el proceso de introducirlos."+
      +sA+"Edsger W. Dijkstra"+pA,
    "640 K deberían ser suficientes para cualquiera."+
      +sA+"Bill Gates, 1981"+pA,
    "Desarrollar la tolerancia a la imperfección es el factor clave para convertir a los que siempre empiezan en personas que siempre terminan."+
      +sA+"Jon Acuff"+pA,
    "Todos los grandes desarrolladores que conoces llegaron a serlo resolviendo problemas para los que no estaban cualificados hasta que realmente lo hicieron."+
      +sA+"Patrick McKenzie"+pA,
    "Al usuario medio le da igual lo que pase, siempre y cuando (1) funcione y (2) sea rápido."+
      +sA+"Daniel J. Bernstein"+pA,
    "Caminar sobre el agua y desarrollar software a partir de unas especificaciones es fácil si ambos están congelados."+
      +sA+"Edward V. Berard"+pA,
    "Sé curioso.<br/> Lee mucho.<br/> Prueba cosas nuevas.<br/> Creo que gran parte de lo que la gente llama inteligencia se reduce a la curiosidad."+
      +sA+"Aaron Swartz"+pA,
    "Lo que un programador puede hacer en un mes, dos programadores pueden hacerlo en dos meses."+
      +sA+"Frederick P. Brooks"+pA,
];

const fechaActual = new Date();
const diaDelMes = fechaActual.getDate();
const indiceFrase = (diaDelMes - 1) % frasesDelDia.length;
const fraseDelDia = frasesDelDia[indiceFrase];
const random = Math.floor(Math.random() * frasesDelDia.length);
const randomH = Math.floor(Math.random() * risasDelDia.length);
console.log("Frase del día: " + fraseDelDia);
//document.getElementById("frase").innerText = frasesDelDia[random];
const removeAccents = str =>
  str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
var str = removeAccents(frasesDelDia[random]).toLowerCase(),
    i = 0,
    isTag,
    text;

var strH = risasDelDia[randomH],
    ih = 0,
    isTagH,
    textH

(function type() {
    text = str.slice(0, ++i);
    if (text === str) return;

    document.getElementById('frase').innerHTML = text;

    var char = text.slice(-1);
    if( char === '<' || char==='&') isTag = true;
    if( char === '>' || char===';') isTag = false;

    if (isTag) return type();
    setTimeout(type, 80);
}());

(function typeH() {
    textH = strH.slice(0, ++ih);
    if (textH === strH) return;

    document.getElementById('humor').innerHTML = textH;

    var charH = textH.slice(-1);
    if( charH === '<' || charH==='&') isTagH = true;
    if( charH === '>' || charH===';') isTagH = false;

    if (isTagH) return typeH();
    setTimeout(typeH, 80);
}());
