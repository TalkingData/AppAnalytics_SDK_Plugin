//
//  BackgroundSessionCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/14.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "BackgroundSessionCommand.h"


@implementation BackgroundSessionCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *bg_enable_str = @"\t[TalkingData backgroundSessionEnabled];";
    
    [self insertEditableWithInvocation:invocation contents:bg_enable_str editPosition:bg_enable_str.length + 1];
    
    completionHandler(nil);
}

@end
