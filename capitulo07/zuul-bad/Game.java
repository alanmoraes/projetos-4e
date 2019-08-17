/**
 *  Esta classe é parte da aplicação "Mundo de Zuul".
 *  O "Mundo de Zuul" é um jogo de aventura em texto simples.  Os Usuários
 *  podem perambular pelo cenário. Isso é tudo! Esse jogo deve ser 
 *  realmente aprimorado para torná-lo mais interessante!
 * 
 *  Para jogar, primeiro crie uma instância desta classe, em seguida, chame
 *  o método "play".
 * 
 *  Essa classe principal cria e inicializa todas as outras: ela cria todas
 *  as salas, cria o Parser ("tradutor") e inicia o jogo propriamente dito.
 *  Ela também interpreta e executa os comandos que o Parser retorna.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Game 
{
    private Parser parser; // "tradutor"/"interpretador"/"analisador"
    private Room currentRoom; // Sala atual do jogador no jogo
        
    /**
     * Cria o jogo e inicializa seu mapa (de jogo) interno.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Cria todas as salas e liga suas saídas umas as outras.
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;
      
        // cria as salas
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // inicializa as saídas das salas
        outside.setExits(null, theatre, lab, pub);
        theatre.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);

        currentRoom = outside;  // iniciar game fora
    }

    /**
     * Rotina principal do jogo. Executa um loop até o fim do jogo.
     */
    public void play() 
    {            
        printWelcome();

        // Entra no loop do comando principal. Aqui lemos repetidamente
        // os comandos e os executamos até que o jogo termine.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null) {
            System.out.print("north ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("east ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("south ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

    /**
     * Dado um comando, processa-o (isto é: executa esse comando).
     * @param command O comando a ser processado.
     * @return Retorna true caso o comando finalize o jogo, false caso contrário.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false; // Se o usuário quer encerrar o jogo

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit"))
            wantToQuit = quit(command);

        return wantToQuit;
    }

    // Implementação dos comandos do usuário:

    /**
     * Imprime alguma informação de ajuda.
     * Aqui imprimimos algumas mensagens estúpidas e enigmáticas,
     * bem como uma lista de comandos.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Tenta ir em uma direção. Se houver uma saída, entra
     * na nova sala, caso contrário, imprime uma mensagem de erro.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // se não houver nenhuma segunda palavra,
            // não sabemos para onde ir
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Tenta sair da sala atual.
        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("You are " + currentRoom.getDescription());
            System.out.print("Exits: ");
            if(currentRoom.northExit != null) {
                System.out.print("north ");
            }
            if(currentRoom.eastExit != null) {
                System.out.print("east ");
            }
            if(currentRoom.southExit != null) {
                System.out.print("south ");
            }
            if(currentRoom.westExit != null) {
                System.out.print("west ");
            }
            System.out.println();
        }
    }

    /** 
     * "Quit" foi inserido. Verifica se o usuário digitou alguma outra
     * palavra na frase apenas para decidir se realmente encerraremos o jogo.
     * @return Retorna true se "command" é um comando capaz de encerrar o jogo, false caso contrário.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // Sinaliza que queremos encerrar o jogo
        }
    }
}
