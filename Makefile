SRC_DIR = src
OUT_DIR = out
SOURCES = $(shell find $(SRC_DIR) -name '*.java')

.PHONY: build run clean

build:
	javac -d $(OUT_DIR) $(SOURCES)

run: build
	java -cp $(OUT_DIR) Main

clean:
	rm -rf $(OUT_DIR)
