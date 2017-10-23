#!/usr/bin/python




def ghettoLog(message):
  file = open("/tmp/ghettoLog.txt","a")
  file.write(message+"\n")
  file.close()


print("Writing to ghetto log")
ghettoLog("check 3")
