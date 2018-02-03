#!/bin/bash

# Cycles through the arbitrary number of the variables
# in format of 'num_*' from 1 while the vars are set


i=1
current=num_$i

while [ ${!current} ]; do
  echo ${!current}
  i=$((i+1))
  current=num_$i
done



