package lista;

import java.util.Scanner;

class Lista {
    private int[] array;
    private int n;

    public Lista(int tam) {
        array = new int[tam];
        n = 0; // quantos elementos estão na lista
    }

    public void removerI() throws Exception {
        if (n <= 0) {
            throw new Exception("Erro ao remover");
        }
        n--;
        for (int i = 0; i < n; i++) {
            array[i] = array[i + 1];
        }
    }

    public void removerF() throws Exception {
        if (n <= 0) {
            throw new Exception("Erro ao remover");
        }
        n--;
    }

    public void remover(int pos) throws Exception{
        if (n <= 0 || pos < 0 || pos > n){
            throw new Exception("Erro ao remover");
        }
        n--;
        for (int i = pos - 1; i < n; i++){
            array[i] = array[i + 1];
        }
    }

    public void inserirI(int x) throws Exception {
        if (n >= array.length) {
            throw new Exception("Erro ao inserir");
        }
        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = x;
        n++;
    }

    public void inserirF(int x) throws Exception {
        if (n >= array.length) {
            throw new Exception("Erro ao inserir");
        }
        array[n] = x;
        n++;
    }

    public void inserir(int pos, int x) throws Exception {
        if (n >= array.length || pos < 0 || pos > n){
            throw new Exception("Erro ao inserir");
        }
        for (int i = n; i >= pos; i--){
            array[i] = array[i - 1];
        }
        array[pos - 1] = x;
        n++;
    }

    public void mostrar() {
        System.out.print("Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }

    public void menu() {
        System.out.println(" ");
        System.out.println("1. Adicionar no início");
        System.out.println("2. Remover no início");
        System.out.println("3. Adicionar ao fim");
        System.out.println("4. Remover no fim");
        System.out.println("5. Adicionar");
        System.out.println("6. Remover");
        System.out.println("7. Mostrar");
        System.out.println("8. Encerrar programa");
        System.out.println(" ");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Tamanho da lista
        System.out.print("Tamanho: ");
        int tam = sc.nextInt();
        Lista lista = new Lista(tam);

        // Opção para o switch case
        System.out.println("Selecione a opção");
        lista.menu();
        int opt = sc.nextInt();
        while (opt != 8) {
            switch (opt) {
                case 1: // Adicionar no inicio
                    try {
                        System.out.println("Qual número adicionar: ");
                        int x = sc.nextInt();
                        lista.inserirI(x);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    lista.menu();
                    opt = sc.nextInt();
                    break;

                case 2: // Remover no inicio
                    try {
                        lista.removerI();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    lista.menu();
                    opt = sc.nextInt();
                    break;

                case 3: // Adicionar no fim
                    try {
                        System.out.println("Qual número adicionar: ");
                        int x = sc.nextInt();
                        lista.inserirF(x);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    lista.menu();
                    opt = sc.nextInt();
                    break;

                case 4: // Remover no fim
                    try {
                        lista.removerF();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    lista.menu();
                    opt = sc.nextInt();
                    break;

                case 5: // Adicionar pos específica
                    System.out.print("Qual posição: ");
                    int pos = sc.nextInt();
                    System.out.print("Qual número adicionar: ");
                    int x = sc.nextInt();
                    try{
                        lista.inserir(pos,x);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    lista.menu();
                    opt = sc.nextInt();
                    break;
                
                case 6: // Remover pos específica
                    System.out.println("Qual posição: ");
                    pos = sc.nextInt();
                    try{
                        lista.remover(pos);
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    lista.menu();
                    opt = sc.nextInt();
                    break;

                case 7: // Mostrar Lista
                    lista.mostrar();
                    lista.menu();
                    opt = sc.nextInt();
                    break;

                case 8: // Encerrar programa
                    sc.close();
                    break;

                default:
                    System.out.println("Opção inválida");
                    lista.menu();
                    opt = sc.nextInt();
                    break;
            }
        }
    }
}
