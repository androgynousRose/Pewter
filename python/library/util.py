import os
from os.path import isfile, join
from pathlib import Path

# Working dir might change depending on environment (Code/IDEA)
def fixWorkingDirectory():
    cwd = Path(os.getcwd())
    if (cwd.name == "python"):
        os.chdir(cwd.parent)