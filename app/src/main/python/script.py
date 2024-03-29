import sys
from os.path import dirname, join
from com.chaquo.python import Python

def main(CodeAreaData):

    file_dir = str(Python.getPlatform().getApplication().getFilesDir())
    filename = join(dirname(file_dir))

    file_dir = str(Python.getPlatform().getApplication().getFilesDir())
    #give file name
    filename = join(dirname(file_dir), 'file.txt')

    try:
        #save a reference to the original standard output
        original_stdout = sys.stdout
        #open new file (file.txt):Fith intention to write data and change standard output to our file
        sys.stdout = open(filename, 'w', encoding = 'utf8', errors="ignore")
        #now execute our code
        exec(CodeAreaData)

        sys.stdout.close()
        #reset the standard output to its original value
        sys.stdout = original_stdout

        #open file and read output and save in variable
        output = open(filename, 'r').read()

    except Exception as e:
        sys.stdout = original_stdout
        output = e
    return str(output)