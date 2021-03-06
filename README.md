# Star Analysis
While studying and looking for patterns between skewness and kurtosis in the absorption spectra of various stars, this program allows for the quick and organized note taking for qualitative observation between high resolution spectra and plot summaries. 

## Installation
Download zip or clone to computer. Use Netbeans or other Java compiler and run main method in StarAnalysis class.

##Use
For high resolution plots: Go to http://astro.uchicago.edu/~dwelty/ew-atom.html and download the needed high resolution plots. Place them in the "hires" folder in the cloned directory. 
For low resolution plots: Go to http://astro.uchicago.edu/~dwelty/DIBplots/ and download the needed summary plots. Place them in the "lowres" folder. As the high resolution plots do not have HD numbers yet, determine which high resolution plots correspond to which low resolution plots and name your files accordingly. (Eg. If kap cas is HD2905, in the high resolution folder, rename file "1kapcas" and in low resolution folder rename file "1HD2905." That way, the program will open both files in the correct order. For information on kurtosis and skewness, please visit https://docs.google.com/spreadsheets/d/1yDG175HyGAld0NeEWB1oSgKd2Ncwf_ncaMhs-yEWGag/edit#gid=0. This link gives skewness and kurtosis data for the 5780 DIB and it also displays various star information (vsini, distance, spectral type, etc.) Additionally, an excel sheet with that information will be included with the source code. For different DIBs, data tables without star information can be found in Advanced Correlations Plot in UChicago DIBs database. This can be used to find data for lines other than 5780.

##Function
This opens up files in the "hires" and "lowres" folders in alphabetical order. So please place files in each folder accordingly, with proper naming so as to indicate which ones you would like to do first. (ie. prepending "(a)" or "(1)" (yes, parentheses are necessary)). The program will open each file up and will ask you to input the various parameters. If some are not available, simply input zero. Begin taking notes and type "DONE" when finished to move on to the next star. To continue with stars already completed, please navigate to the "Issues" tab in the repository and click the one with the "In Progress" tab. That as all the appropriate files to continue working.
