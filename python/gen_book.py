import os
from os.path import isfile, join
from pathlib import Path
from library import util
import yaml
from library.FileUtil import FileUtil
from library.GemUtil import GemUtil

util.fixWorkingDirectory()

print(os.getcwd())

print("About to generate gem book data...")

b = FileUtil.get_yaml_as_json("python/bookdata", "gemdata.yaml")

for gem_name, gem in b["gems"].items():

    GemUtil(gem_name, gem, False).save()
    GemUtil(gem_name, gem, True).save()


print("Gem data generated.")

#print(b)

