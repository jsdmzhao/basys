echo %date:~0,4%年%date:~5,2%月%date:~8,2%日 %time:~0,2%时%time:~3,2%分%time:~6,2%秒 开始导入数据>>control.log
sqlldr userid=mansys/mansys@scpt control=impdata.ctl
echo %date:~0,4%年%date:~5,2%月%date:~8,2%日 %time:~0,2%时%time:~3,2%分%time:~6,2%秒 结束导入数据>>control.log
echo %date:~0,4%年%date:~5,2%月%date:~8,2%日 %time:~0,2%时%time:~3,2%分%time:~6,2%秒 开始更新数据字典项>>control.log
sqlplus mansys/mansys@scpt @alter.sql
echo %date:~0,4%年%date:~5,2%月%date:~8,2%日 %time:~0,2%时%time:~3,2%分%time:~6,2%秒 结束更新数据字典项>>control.log
echo %date:~0,4%年%date:~5,2%月%date:~8,2%日 %time:~0,2%时%time:~3,2%分%time:~6,2%秒 结束更新>>control.log
exit
