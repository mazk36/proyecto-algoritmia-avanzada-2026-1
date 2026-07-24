package uni.edu.pe.Grafos;

import java.util.*;

public class oilDeposit {
    static final int MAX = 100 ;
    static boolean[][] grafo = new boolean[MAX][MAX];
    static boolean[][] visited = new boolean[MAX][MAX] ;
    static int[] di = {1,-1,0,0,1 ,1,-1,-1 };
    static int[] dj = {0,0,1,-1,-1,1, 1,-1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt(); int m = sc.nextInt();
            if(m==0 || n==0)break;
            for (int i = 0 ; i < n ; i++){
                String linea = sc.next();
                for(int j = 0 ; j<m ; j++){
                    visited[i][j] = false;
                    char c = linea.charAt(j);
                    grafo[i][j] = (c=='@');
                }
            }
            // bfs
            int cont = 0;
            for(int i = 0 ; i < n ; i++){
                for (int j = 0; j < m ; j++){
                    if(grafo[i][j] && !visited[i][j]){
                        cont++;
                        Queue<Integer> q = new ArrayDeque<>();
                        q.add(i*m+j);
                        while (!q.isEmpty()){
                            int v = q.poll();
                            int vi = v/m;
                            int vj = v%m;
                            for (int k = 0 ; k < 8; k++){
                                int ui = vi+ di[k]; int uj = vj +dj[k];
                                if(ui <0 ||uj < 0 || ui > n || uj > m || !grafo[ui][uj] || visited[ui][uj]) continue;
                                q.add(ui*m+uj);
                                visited[ui][uj] = true;
                            }
                        }
                    }
                }
            }
            System.out.println(cont);
        }
    }

}
