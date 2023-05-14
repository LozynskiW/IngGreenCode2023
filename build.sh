#!/bin/bash

git_repo="https://github.com/LozynskiW/IngGreenCode2023.git"

# directory where cloned repo will be saved
repo_directory="LozynskiW"

git clone "$git_repo" "$repo_directory"

mvn -f "$repo_directory/" package

# path to Application.java file in project
source_directory="$repo_directory/src/main/java/ing"

mvn -f "$repo_directory/" compiler:compile

if [ $? -eq 0 ]; then
  echo "Compilation successful."
else
  echo "Compilation failed."
  exit 1
fi
