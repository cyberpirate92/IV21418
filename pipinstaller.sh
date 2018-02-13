FAILED=()
if [ $1 ]
then
    LIST=$(grep .*==.*,$ $1 | tr -d [:space:] | tr ',' '\n'); 
    for LIB in $LIST
    do
        echo "Installing $LIB ..."
        pip install $LIB >/dev/null 2>&1
        if [ $? -ne 0 ]
        then
            FAILED+=("$LIB")
        fi
    done
    if [ ${#FAILED[@]} == 0 ]
    then
        echo "All packages installed successfully"
    else
        echo "----------------------------------------------------------"
        echo "The following ${#FAILED[@]} packages failed to install"
        for F in "${FAILED[@]}"
        do
            echo $F
        done
        echo "----------------------------------------------------------"
    fi
else
    echo "Usage: ./pipinstaller.sh <filename>";
fi