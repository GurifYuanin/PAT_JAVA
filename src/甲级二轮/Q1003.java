package 甲级二轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1003 {
  public static void main(String[] args) throws IOException {
    String[] arr;
    int[][] path;
    int[] res, dis, allRes, pathCount;
    int cityNum, pathNum, curCity, tarCity, i, j, min, index, start, end;
    boolean[] visited;
    int MAX = Integer.MAX_VALUE / 2;
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    arr = buf.readLine().split(" ");
    cityNum = Integer.parseInt(arr[0]);
    pathNum = Integer.parseInt(arr[1]);
    curCity = Integer.parseInt(arr[2]);
    tarCity = Integer.parseInt(arr[3]);
    path = new int[cityNum][cityNum];
    res = new int[cityNum];
    dis = new int[cityNum];
    allRes = new int[cityNum];
    pathCount = new int[cityNum];
    visited = new boolean[cityNum];
    arr = buf.readLine().split(" ");
    for (i = 0; i < cityNum; i++) {
      res[i] = Integer.parseInt(arr[i]);
      Arrays.fill(path[i], MAX);
    }
    Arrays.fill(dis, MAX);
    Arrays.fill(visited, false);
    for (i = 0; i < pathNum; i++) {
      arr = buf.readLine().split(" ");
      start = Integer.parseInt(arr[0]);
      end = Integer.parseInt(arr[1]);
      path[start][end] = path[end][start] =  Integer.parseInt(arr[2]);
    }
    buf.close();
    
    if (curCity == tarCity) { // 特殊情况
      System.out.print(1 + " " + res[curCity]);
      return;
    }
    dis[curCity] = 0;
    path[curCity][curCity] = 0;
    pathCount[curCity] = 1;
    allRes[curCity] = res[curCity];
    for (i = 0; i < cityNum; i++) {
      min = MAX;
      index = tarCity;
      for (j = 0; j < cityNum; j++) {
        if (min > dis[j] && !visited[j]) { // 是dis不是path
          min = dis[j];
          index = j;
        }
      }
      if (min == MAX || index == tarCity) {
        break;
      }
      visited[index] = true;
      for (j = 0; j < cityNum; j++) {
        if (!visited[j]) {
          if (dis[j] > dis[index] + path[index][j]) {
            dis[j] = dis[index] + path[index][j];
            allRes[j] = allRes[index] + res[j];
            pathCount[j] = pathCount[index];
          } else {
            if (dis[j] == dis[index] + path[index][j]) {
              pathCount[j] += pathCount[index];
              if (allRes[j] < allRes[index] + res[j]) {
                allRes[j] = allRes[index] + res[j];
          }
            }
          }
        }
      }
    }
    System.out.print(pathCount[tarCity] + " " + allRes[tarCity]);
  }
}
