#!/usr/bin/python
import sys, re

def main():
	with open(sys.argv[1], "r") as fp:
		lines = fp.readlines()

		for line in lines:

			if line_valid(line):
				print("Commit realizado com sucesso!")
				sys.exit(0)
			else:
				print("ERROR! Commit fora do padrao!")
				sys.exit(1)

def line_valid(line):
	return re.match("#\s?\d{,10}\s?-\s?(\w|\s){,49}", line)

if __name__ == "__main__":
	main()