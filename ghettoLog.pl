#!/usr/bin/perl

use strict;
use warnings;

sub ghettoLog #message
{
  my $message = $_[0];
  if (defined $message) {
    my $outfile = "/tmp/ghettoLog.log";
    open(FILE,">> $outfile") || die "problem opening $outfile\n";
    print FILE "$message\n";
    close(FILE);
  }
}


ghettoLog("using sub 2");
ghettoLog("another sub 3");


