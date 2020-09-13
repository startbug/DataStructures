package com.ggs.recursion;

/**
 * @Author Starbug
 * @Date 2020/9/13 0:01
 * 使用递归的方式,解决小球找路问题
 */
public class Maze {
    public static void main(String[] args) {
        int[][] maze = new int[8][7];

        //0表示未走过,1表示为墙壁,2表示为已经走过的点,3表示该点无路可走
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = 1;
            maze[i][maze[i].length - 1] = 1;
        }
        for (int i = 0; i < maze[0].length; i++) {
            maze[0][i] = 1;
            maze[maze.length - 1][i] = 1;
        }

        //设置挡板
        maze[3][1] = 1;
        maze[3][2] = 1;
        maze[1][2] = 1;
        maze[2][2] = 1;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=========================================");
        //传入数组和小球起点坐标,终点默认设置为6 5
        boolean flag = findAWayOut2(maze, 1, 1);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean findAWayOut(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        } else {
            //如果该位置还未走过
            if (maze[i][j] == 0) {
                maze[i][j] = 2;
                //定义路线策略,下->右->上->左
                if (findAWayOut(maze, i + 1, j)) {
                    return true;
                } else if (findAWayOut(maze, i, j + 1)) {
                    return true;
                } else if (findAWayOut(maze, i - 1, j)) {
                    return true;
                } else if (findAWayOut(maze, i, j - 1)) {
                    return true;
                } else {
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                //该位置是1,2或者3
                return false;
            }
        }
    }

    private static boolean findAWayOut2(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        } else {
            //如果该位置还未走过
            if (maze[i][j] == 0) {
                maze[i][j] = 2;
                //定义路线策略,上->左->下->右
                if (findAWayOut2(maze, i - 1, j)) {
                    return true;
                } else if (findAWayOut2(maze, i, j - 1)) {
                    return true;
                } else if (findAWayOut2(maze, i + 1, j)) {
                    return true;
                } else if (findAWayOut2(maze, i, j + 1)) {
                    return true;
                } else {
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                //该位置是1,2或者3
                return false;
            }
        }
    }

}
