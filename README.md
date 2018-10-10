## Android Issue 117476786

This app is just a sample for showing the issue 117476786.

Simply run the Application on debug / release and try any of the flows described below. The first one works as expected, the second doesn't (and it's the bug)

If you wish to just install the APK, you can find it in the root of this VCS.

[Issue link](https://issuetracker.google.com/issues/117476786)

## Remove a key:
1. Add a key (press the button 'Add key')
2. Remove a key (press the button 'Remove key')

Expected output: You should see 2 `Toast` from the registered object in the shared preferences that was called (one for the add, another for the remove)

## Clear the shared preferences:
1. Add a key (press the button 'Add key')
2. Clear all keys (press the button 'Clear keys')

Expected output: You should see 2 `Toast` from the registered object in the shared preferences that was called (one for the add, N for the clear (where N=number_of_keys, so one for each key removed)).
Actual output: Only 1 `Toast` will show (from the add). The registered object isn't called from the shared preferences when the clear is called (and the keys are removed)
