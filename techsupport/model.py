#!/usr/bin/env python2
# -*- coding:utf-8 -*-
#用于技术支持单模型

'''
技术支持单基础模型
'''

class TechSupport:
    def __init__(self):
        self.id=0
        self.stno=''
        self.st_leaders = []
        self.st_departments = []
        self.st_content=''
        self.st_region = ''
        self.st_seqno=0
        self.trackings = []
        self.supervisions = []
        
        #附件部分
        self.attachments = []

class Attatchment:
    def __init__(self,id,techsupport):
        self.techsupport = None
        self.id = 0
        self.filename=''
        self.filepath=''
        self.type=''
        self.comments = ''
        
class Tracking:
    def __init__(self):
        self.id=0
        self.techsupport=None
        self.type=''
        self.content=''
        self.writer=''
        self.write_time=''
        
class Supervision:
    def __init__(self):
        self.id=0
        self.techsupport=None
        self.content = ''
        self.writer=''
        self.write_time=''

        