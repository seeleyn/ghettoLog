#!/usr/bin/python

import sys;


def ghettoLog(message):
  file = open("/tmp/ghettoLog.txt","a")
  file.write(message+"\n")
  file.close()


print("Writing to ghetto log")
cmdLineArgsAsString = ";".join(sys.argv)
ghettoLog("command line args are "+cmdLineArgsAsString)
