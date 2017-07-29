import json
import xml.etree.ElementTree as ET
tree = ET.parse('Landcover_info.xml')
root = tree.getroot()
print root.tag
print root.attrib
dict = {}
i=0
json_data = {
	"name":"Placemark",
	"type":"FeatureCollection",
	"features":[
		
	]
    }
for placemark in root.iter('Placemark'):
    datas = placemark.find('ExtendedData')
    coord = placemark.find('Point').find('coordinates').text
    
    for data in datas:
        val = data.get('name')
        #print val
        if val == "first":
            landcover = data.find('value').text
    #dict[coord] = landcover
    feature = {
			"type":"Feature",
			"geometry":
                {
                    "type":"Point",
                    "coordinates":[-69.85,43.95]
                },
            "properties":{"landcover":13}
		}
    feature['properties']['landcover'] = landcover
    feature['geometry']['coordinates'] = coord.split(',')
    i+=1
    json_data['features'].append(feature)
    print i
with open("C:/Users/Nitin/Desktop/output1.txt", 'ab') as outfile:
    json.dump(json_data, outfile)