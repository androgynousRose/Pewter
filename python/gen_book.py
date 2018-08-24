import os
from os.path import isfile, join
from pathlib import Path
from library import util

util.fixWorkingDirectory()

print(os.getcwd())

print("Hello, World!")

print("Code for generating book jsons from yaml files will go here eventually.")

mypath = "."

onlyfiles = [f for f in os.listdir(mypath) if not isfile(join(mypath, f))]

print(onlyfiles)