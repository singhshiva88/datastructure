package com.CodingCrack;

public class AngleBetweenHourAndMinute
{
  public static void main(String[] args)
  {
    String str = "3:27";
    int hour = Integer.parseInt(str.split(":")[0]);
    int minute = Integer.parseInt(str.split(":")[1]);
    int angleInDegrees = getMinuteAngle(minute);
    int hoursInDegrees = getHourAngle(hour, minute);
    System.out.println("angleInDegrees: "+ angleInDegrees);
    System.out.println("hoursInDegrees: "+ hoursInDegrees);
    System.out.println(Math.min(Math.abs(angleInDegrees - hoursInDegrees), 360 - Math.abs(angleInDegrees - hoursInDegrees)));
  }

  private static int getHourAngle(int hour, int minute)
  {
    int initialAngle = hour * 30;
    int offset = minute * 30/360;
    return initialAngle + offset;
  }

  private static int getMinuteAngle(int minute)
  {
    return minute * 360/60;
  }
}
