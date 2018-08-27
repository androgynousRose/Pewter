import json
from library.FileUtil import FileUtil

class GemUtil:

    base_path = "src/main/resources/assets/pewter/"

    armory_path = base_path + "armory_book/en_us/modifiers/"

    tool_path = base_path + "tinker_book/en_us/modifiers/"

    
    def __init__(self, gem_name, gem_dict, is_tool):
        self.name = gem_name
        self.data = gem_dict
        self.is_tool = is_tool

        if not self.is_tool:
            self.name += "_armor"


    def get_json(self):
        info = {}

        if self.is_tool:
            info["modifier"] = self.name
            info["effects"] = self.data["tool"]
            info["demoTool"] = [
                "tconstruct:pickaxe",
                "tconstruct:broadsword",
                "tconstruct:arrow"
            ]
        else:
            info["armormodifier"] = self.name
            info["effects"] = self.data["armor"]
            info["demoArmor"] = [
                "conarm:helmet",
                "conarm:chestplate",
                "conarm:leggings",
                "conarm:boots"
            ]
            
        
        if "all" in self.data:
                info["effects"] += self.data["all"]

        info["text"] = []
        info["text"].append({"text": self.data["desc"]})


        return json.dumps(info, indent=4, sort_keys=True)

    def save(self):
        
        path_to_use = self.tool_path if self.is_tool else self.armory_path

        with open(path_to_use + self.name + ".json", 'w') as json_file:
            json_file.write(self.get_json())
            json_file.close()

