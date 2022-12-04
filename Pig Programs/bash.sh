export JAVA_HOME=$(readlink -f $(which javac) | awk 'BEGIN {FS="/bin"} {print $1}')
if ! command -v pig &> /dev/null
then
export PATH=$(echo $PATH):$(pwd)/bin
fi