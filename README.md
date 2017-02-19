Used to practise:

1 algorithm(couldn't bear any indescribable fucking IndentationError more of python)

2 junit(learn and practise from zero)

3 tdd(whatever)

public class UndirectedGraphTraversal {

    private int count=0;
    private ArrayList[] graph;
    boolean[] visited;
    public int undirectedGraphTraversalWays(int[][] nums,int n){

       graph=new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i]=new ArrayList();
        }

        visited=new boolean[n];

        for(int i=0;i<nums.length;i++){
            graph[nums[i][0]-1].add(nums[i][1]-1);
            graph[nums[i][1]-1].add(nums[i][0]-1);
        }


        visited[0]=true;
        undirectedGraphTraversalWaysHelper(graph[0]);
        return count;

    }


    private boolean undirectedGraphTraversalWaysHelper(ArrayList nodes){


        boolean flag=true;
        for(boolean visitedFlag:visited){
            flag&=visitedFlag;
        }

        if(flag){
            return true;
        }


        for(Object node:nodes){

            int index=((Integer) node).intValue();

            if(visited[index]){
                continue;
            }
            visited[index]=true;

            if(undirectedGraphTraversalWaysHelper(graph[index])){
                count++;
            }

            visited[index]=false;
        }

        return false;



    }

