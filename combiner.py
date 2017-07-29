import glob
import csv
data = []
for filename in glob.glob('*.csv'):
    del data[:]
    print filename
    split_name = filename.split("_")
    latitude = split_name[1]
    longitude = split_name[2]
    f = open(filename)
    csv_f = csv.reader(f)
    i = 0
    for row in csv_f:
        row.insert(0,longitude)
        row.insert(0,latitude)
        if i == 0:
            i+=1
        else:
            data.insert(i-1,row)
            i+=1
    with open("D:/Big Data/Project/Dataset/Solar Power Data/combined/comb_data.csv", "ab") as csv_file:
        writer = csv.writer(csv_file, delimiter=',')
        for line in data:
            writer.writerow(line)
