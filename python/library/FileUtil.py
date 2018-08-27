import yaml
import os
from os.path import isfile, join
from pathlib import Path

class FileUtil:

    @classmethod
    def get_folder(self, rel_path):
        full_path = Path(os.getcwd() + "/" + rel_path + "/")
        if (full_path.is_dir()):
            return full_path
    
    @classmethod
    def get_file(self, rel_path):
        full_path = Path(os.getcwd() + "/" + rel_path + "/")
        if (full_path.is_file()):
            return full_path

    @classmethod
    def get_file_contents(self, rel_path, name):
        full_path = self.get_folder(rel_path).joinpath(name)
        data = ""
        if (full_path.is_file()):
            with open(full_path, 'r') as the_file:
                data = the_file.read()
        return data

    @classmethod
    def get_yaml_as_json(self, relPath: str, name: str) -> dict:
        contents = self.get_file_contents(relPath, name)
        return yaml.safe_load(contents)
    

