//
//  EAuthDocumentCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "EAuthDocumentCommand.h"
#import <AppKit/AppKit.h>

@implementation EAuthDocumentCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    [[NSWorkspace sharedWorkspace] openURL:[NSURL URLWithString:@"http://doc.talkingdata.com/posts/279"]];
    
    completionHandler(nil);
}

@end
