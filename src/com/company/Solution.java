package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result
{

  /*
   * Complete the 'getSelectionStatus' function below.
   *
   * The function is expected to return a 2D_STRING_ARRAY.
   * The function accepts 2D_STRING_ARRAY applications as parameter.
   */

  public static List<List<String>> getSelectionStatus(List<List<String>> applications)
  {
    List<Player> allPlayers = initializeAllPlayers(applications);
    List<Player> eligiblePlayersList = PlayerFilter.filterEligiblePlayers(allPlayers);
    PlayerManager.populateSelectionGroups(eligiblePlayersList);

    // List<Player> rejectedPlayersList = PlayerFilter.filterNonEligiblePlayers(players);

    // List<Player> outputFormatPlayers = getAllPlayersInOutputFormat(allPlayers);
    return null;
  }

  private static List<Player> initializeAllPlayers(List<List<String>> applications)
  {
    List<Player> players = new ArrayList<>();
    for (List<String> list: applications)
    {
      Player player = new Player(list.get(0), Double.parseDouble(list.get(1)), Integer.parseInt(list.get(2)),
              Integer.parseInt(list.get(3)), Integer.parseInt(list.get(4)));
      players.add(player);
    }
    // create objects
    return players;
  }

  private static List<List<String>> getAllPlayersInOutputFormat(List<Player> players)
  {
    // create objects
    return null;
  }
}

class PlayerManager
{
  public static void populateSelectionGroups(List<Player> eligiblePlayers)
  {
    PriorityQueue<Player> strikers = new PriorityQueue<>();
    PriorityQueue<Player> defenders = new PriorityQueue<>();
    List<Player> allRounders = new ArrayList<>();
    for (Player player : eligiblePlayers)
    {
      if (FitnessFactor.isStrikerPlayer(player) && FitnessFactor.isDefenderPlayer(player))
      {
        player.setSelectionGroup(SelectionGroup.BOTH);
        allRounders.add(player);
      }
      else if (FitnessFactor.isStrikerPlayer(player))
      {
        player.setSelectionGroup(SelectionGroup.STRIKER);
        strikers.add(player);
      }
      else
      {
        player.setSelectionGroup(SelectionGroup.DEFENDER);
        defenders.add(player);
      }
    }

    while (!allRounders.isEmpty())
    {
      if (strikers.size() < defenders.size())
      {
        strikers.add(allRounders.remove(allRounders.size() - 1));
      }
      else if (strikers.size() > defenders.size())
      {
        defenders.add(allRounders.remove(allRounders.size() - 1));
      }
      else
      {
        strikers.add(allRounders.remove(allRounders.size() - 1));
      }
    }

      while (strikers.size() < defenders.size())
      {
        strikers.poll();
      }
      while (defenders.size() < strikers.size())
      {
        defenders.poll();
      }
  }
}

class PlayerFilter
{
  public static List<Player> filterEligiblePlayers(List<Player> players)
  {
    return players.stream().filter(p -> (FitnessFactor.isStrikerPlayer(p) ||
            FitnessFactor.isDefenderPlayer(p))).collect(Collectors.toList());
  }

  public static List<Player> filterNonEligiblePlayers(List<Player> players)
  {
    return players.stream().filter(p -> (!FitnessFactor.isStrikerPlayer(p) &&
            !FitnessFactor.isDefenderPlayer(p))).collect(Collectors.toList());
  }

  public static List<Player> filterPureStrikers(List<Player> players)
  {
    return players.stream().filter(p -> (FitnessFactor.isStrikerPlayer(p) &&
            !FitnessFactor.isDefenderPlayer(p))).collect(Collectors.toList());
  }

  public static List<Player> filterPureDefenders(List<Player> players)
  {
    return players.stream().filter(p -> (!FitnessFactor.isStrikerPlayer(p) &&
            FitnessFactor.isDefenderPlayer(p))).collect(Collectors.toList());
  }

  public static List<Player> filterAllRounders(List<Player> players)
  {
    return players.stream().filter(p -> (FitnessFactor.isStrikerPlayer(p) &&
            FitnessFactor.isDefenderPlayer(p))).collect(Collectors.toList());
  }
}

class FitnessFactor
{
  static final double MIN_HEIGHT = 5.8;
  static final int MAX_BMI = 23;
  static final int MIN_GOALS_SCORED = 50;
  static final int MIN_GOALS_DEFENDED = 30;

  public static boolean isFitPlayer(Player player)
  {
    return player.getHeight() >= MIN_HEIGHT && player.getBmi() <= MAX_BMI;
  }

  public static boolean isStrikerPlayer(Player player)
  {
    return isFitPlayer(player) && player.getScores() >= MIN_GOALS_SCORED;
  }

  public static boolean isDefenderPlayer(Player player)
  {
    return isFitPlayer(player) && player.getDefends() >= MIN_GOALS_DEFENDED;
  }
}

class Player
{
  private String name;
  private double height;
  private int bmi;
  private int scores;
  private int defends;
  private SelectionGroup selectionGroup;

  public Player(String name, double height, int bmi, int scores, int defends)
  {
    this.name = name;
    this.height = height;
    this.bmi = bmi;
    this.scores = scores;
    this.defends = defends;
    this.selectionGroup = SelectionGroup.NA;
  }

  /**
   * @return the name
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * @return the height
   */
  public double getHeight()
  {
    return height;
  }

  /**
   * @param height the height to set
   */
  public void setHeight(double height)
  {
    this.height = height;
  }

  /**
   * @return the bmi
   */
  public int getBmi()
  {
    return bmi;
  }

  /**
   * @param bmi the bmi to set
   */
  public void setBmi(int bmi)
  {
    this.bmi = bmi;
  }

  /**
   * @return the scores
   */
  public int getScores()
  {
    return scores;
  }

  /**
   * @param scores the scores to set
   */
  public void setScores(int scores)
  {
    this.scores = scores;
  }

  /**
   * @return the defends
   */
  public int getDefends()
  {
    return defends;
  }

  /**
   * @param defends the defends to set
   */
  public void setDefends(int defends)
  {
    this.defends = defends;
  }

  /**
   * @return the selectionGroup
   */
  public SelectionGroup getSelectionGroup()
  {
    return selectionGroup;
  }

  /**
   * @param selectionGroup the selectionGroup to set
   */
  public void setSelectionGroup(SelectionGroup selectionGroup)
  {
    this.selectionGroup = selectionGroup;
  }
}

enum SelectionGroup
{
  STRIKER,
  DEFENDER,
  BOTH,
  NA
}

public class Solution
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int applicationsRows = Integer.parseInt(bufferedReader.readLine().trim());
    int applicationsColumns = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<String>> applications = new ArrayList<>();

    IntStream.range(0, applicationsRows).forEach(i -> {
      try
      {
        applications.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
        );
      }
      catch (IOException ex)
      {
        throw new RuntimeException(ex);
      }
    });

    List<List<String>> result = Result.getSelectionStatus(applications);

    result.stream()
            .map(
                    r -> r.stream()
                            .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
              try
              {
                bufferedWriter.write(e);
              }
              catch (IOException ex)
              {
                throw new RuntimeException(ex);
              }
            });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
